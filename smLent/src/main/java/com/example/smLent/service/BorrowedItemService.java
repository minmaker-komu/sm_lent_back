package com.example.smLent.service;

import com.example.smLent.domain.BorrowedItem;
import com.example.smLent.domain.Item;
import com.example.smLent.domain.Member;
import com.example.smLent.dto.BorrowedItemDto;
import com.example.smLent.repository.BorrowedItemRepository;
import com.example.smLent.repository.ItemRepository;
import com.example.smLent.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowedItemService {

    private final ItemRepository itemRepository;
    private final BorrowedItemRepository borrowedItemRepository;
    private final MemberRepository memberRepository;

    public BorrowedItemService(ItemRepository itemRepository, BorrowedItemRepository borrowedItemRepository, MemberRepository memberRepository) {
        this.itemRepository = itemRepository;
        this.borrowedItemRepository = borrowedItemRepository;
        this.memberRepository = memberRepository;
    }

    // 빌려준

    @Transactional
    public BorrowedItemDto addItemAndBorrowedItem(BorrowedItemDto borrowedItemDto) {
        // Step 1: Item 테이블에 물품 정보 저장
        Item item = new Item();
        item.setName(borrowedItemDto.getItemName());
        item.setPrice(borrowedItemDto.getPrice());
        item.setSpecialNote(borrowedItemDto.getSpecialNote());

        Item savedItem = itemRepository.save(item);

        // Step 2: Member 확인
        Member member = memberRepository.findById(borrowedItemDto.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        // Step 3: BorrowedItem 테이블에 빌린 상태 저장
        BorrowedItem borrowedItem = new BorrowedItem();
        borrowedItem.setItem(savedItem); // Item 테이블에 저장된 ID 연결
        borrowedItem.setMember(member);
        borrowedItem.setSpecialNote(borrowedItemDto.getSpecialNote());
        borrowedItem.setBorrowedTime(LocalDateTime.now());

        BorrowedItem savedBorrowedItem = borrowedItemRepository.save(borrowedItem);

        // Step 4: 반환 DTO 생성
        return new BorrowedItemDto(
                savedBorrowedItem.getId(),
                savedItem.getId(),
                member.getId(),
                savedItem.getName(),
                savedItem.getPrice(),
                savedItem.getSpecialNote(),
                savedBorrowedItem.getBorrowedTime()
        );
    }

    @Transactional(readOnly = true)
    public List<BorrowedItemDto> getBorrowedItemsByUser(Long memberId) {
        // 사용자가 빌려준 물건 조회
        List<BorrowedItem> borrowedItems = borrowedItemRepository.findByMemberId(memberId);

        // BorrowedItem을 BorrowedItemDto로 변환
        return borrowedItems.stream()
                .map(borrowedItem -> {
                    Item item = borrowedItem.getItem();
                    return new BorrowedItemDto(
                            borrowedItem.getId(),
                            item.getId(),
                            memberId,
                            item.getName(),
                            item.getPrice(),
                            item.getSpecialNote(),
                            borrowedItem.getBorrowedTime()
                    );
                })
                .collect(Collectors.toList());
    }

    /**
     * 특정 대여 기록 삭제
     */
    @Transactional
    public void deleteBorrowedItem(Long borrowedItemId) {
        // BorrowedItem이 존재하는지 확인
        BorrowedItem borrowedItem = borrowedItemRepository.findById(borrowedItemId)
                .orElseThrow(() -> new RuntimeException("BorrowedItem not found with ID: " + borrowedItemId));

        // BorrowedItem 삭제
        borrowedItemRepository.delete(borrowedItem);

        // 관련된 Item도 삭제 (선택 사항: 필요 시 조건에 따라 삭제)
        Item item = borrowedItem.getItem();
        itemRepository.delete(item);
    }
}
