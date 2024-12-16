package com.example.smLent.controller;

import com.example.smLent.dto.BorrowedItemDto;
import com.example.smLent.service.BorrowedItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 빌려준 물건들 (실수로 반대로 작성했어요 주석만 보고 나누시면 됩니다.)
@RestController
@RequestMapping("/api/borrowed-items")
public class BorrowedItemController {

    private final BorrowedItemService borrowedItemService;

    public BorrowedItemController(BorrowedItemService borrowedItemService) {
        this.borrowedItemService = borrowedItemService;
    }

    // 빌려준 물건 조회
    @GetMapping
    public List<BorrowedItemDto> getBorrowedItemsByUser(@RequestParam Long userId) {
        return borrowedItemService.getBorrowedItemsByUser(userId);
    }

    // 빌려준 물건 추가
    @PostMapping("/add")
    public BorrowedItemDto addBorrowedItem(@RequestBody BorrowedItemDto borrowedItemDto) {
        if (borrowedItemDto.getItemName() == null || borrowedItemDto.getPrice() <= 0) {
            throw new IllegalArgumentException("Item name and price must not be null or invalid");
        }
        return borrowedItemService.addItemAndBorrowedItem(borrowedItemDto);
    }

    // 빌려준 물건 삭제
    @DeleteMapping("/{id}")
    public void deleteBorrowedItem(@PathVariable Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid borrowed item ID");
        }
        borrowedItemService.deleteBorrowedItem(id);
    }
}
