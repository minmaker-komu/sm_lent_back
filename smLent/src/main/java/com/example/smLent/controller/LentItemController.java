package com.example.smLent.controller;

import com.example.smLent.dto.LentItemDto;
import com.example.smLent.service.LentItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 빌린 물건 (대여하기)
@RestController
@RequestMapping("/api/lent-items")
public class LentItemController {

    private final LentItemService lentItemService;

    public LentItemController(LentItemService lentItemService) {
        this.lentItemService = lentItemService;
    }

    // 빌린 물건 조회
    @GetMapping
    public List<LentItemDto> getLentItemsByUser(@RequestParam Long userId) {
        return lentItemService.getLentItemsByUser(userId);
    }

    // 빌린 물건 추가
    @PostMapping("/add")
    public LentItemDto addItemAndLentItem(@RequestBody LentItemDto lentItemDto) {
        if (lentItemDto.getItemName() == null || lentItemDto.getPrice() <= 0) {
            throw new IllegalArgumentException("Item name and price must not be null or invalid");
        }
        return lentItemService.addItemAndLentItem(lentItemDto);
    }

    // 빌린 물건 삭제
    @DeleteMapping("/{id}")
    public void deleteLentItem(@PathVariable Long id) {
        lentItemService.deleteLentItem(id);
    }
}
