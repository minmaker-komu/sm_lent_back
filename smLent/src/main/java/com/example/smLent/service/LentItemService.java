package com.example.smLent.service;

import com.example.smLent.domain.Item;
import com.example.smLent.domain.LentItem;
import com.example.smLent.domain.Member;
import com.example.smLent.dto.LentItemDto;
import com.example.smLent.repository.ItemRepository;
import com.example.smLent.repository.LentItemRepository;
import com.example.smLent.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

@Service
public class LentItemService {

    private final ItemRepository itemRepository;
    private final LentItemRepository lentItemRepository;
    private final MemberRepository memberRepository;

    public LentItemService(ItemRepository itemRepository, LentItemRepository lentItemRepository, MemberRepository memberRepository) {
        this.itemRepository = itemRepository;
        this.lentItemRepository = lentItemRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public LentItemDto addItemAndLentItem(LentItemDto lentItemDto) {
        // Step 1: Item 테이블에 물품 정보 저장
        Item item = new Item();
        item.setName(lentItemDto.getItemName());
        item.setPrice(lentItemDto.getPrice());
        item.setSpecialNote(lentItemDto.getSpecialNote());

        Item savedItem = itemRepository.save(item);

        // Step 2: Member 확인
        Member member = memberRepository.findById(lentItemDto.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        // Step 3: LentItem 테이블에 빌려준 상태 저장
        LentItem lentItem = new LentItem();
        lentItem.setItem(savedItem); // Item 테이블에 저장된 ID 연결
        lentItem.setMember(member);
        lentItem.setCreatedAt(LocalDateTime.now());

        LentItem savedLentItem = lentItemRepository.save(lentItem);

        // Step 4: 반환 DTO 생성
        return new LentItemDto(
                savedLentItem.getId(),
                savedItem.getId(),
                member.getId(),
                savedItem.getName(),
                savedItem.getPrice(),
                savedItem.getSpecialNote(),
                savedLentItem.getCreatedAt()
        );
    }

    /**
     * 특정 사용자가 빌려준 물건 목록 조회
     */
    @Transactional(readOnly = true)
    public List<LentItemDto> getLentItemsByUser(Long memberId) {
        // 사용자가 빌려준 물건 조회
        List<LentItem> lentItems = lentItemRepository.findByMemberId(memberId);

        // LentItem을 LentItemDto로 변환
        return lentItems.stream()
                .map(lentItem -> {
                    Item item = lentItem.getItem();
                    return new LentItemDto(
                            lentItem.getId(),
                            item.getId(),
                            memberId,
                            item.getName(),
                            item.getPrice(),
                            item.getSpecialNote(),
                            lentItem.getCreatedAt()
                    );
                })
                .collect(Collectors.toList());
    }

    /**
     * 특정 대여 기록 삭제
     */
    @Transactional
    public void deleteLentItem(Long lentItemId) {
        // LentItem이 존재하는지 확인
        LentItem lentItem = lentItemRepository.findById(lentItemId)
                .orElseThrow(() -> new RuntimeException("LentItem not found with ID: " + lentItemId));

        // LentItem 삭제
        lentItemRepository.delete(lentItem);

        // 관련된 Item도 삭제 (선택 사항: 필요 시 조건에 따라 삭제)
        Item item = lentItem.getItem();
        itemRepository.delete(item);
    }
}