package com.example.smLent.dto;

import java.time.LocalDateTime;

public class LentItemDto {
    private Long id;
    private Long itemId; // 물건 ID
    private Long memberId; // 사용자 ID (필드가 있어야 함)
    private String itemName;
    private int price;
    private String specialNote;
    private LocalDateTime createdAt;

    public LentItemDto() {
    }

    public LentItemDto(Long id, Long itemId, Long memberId, String itemName, int price, String specialNote, LocalDateTime createdAt) {
        this.id = id;
        this.itemId = itemId;
        this.memberId = memberId;
        this.itemName = itemName;
        this.price = price;
        this.specialNote = specialNote;
        this.createdAt = createdAt;
    }

    public LentItemDto(Long id, Long itemId, String itemName, int price, String specialNote, LocalDateTime createdAt) {
        this.id = id;
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.specialNote = specialNote;
        this.createdAt = createdAt;
    }

    // 기존 생성자

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    // 나머지 Getters and Setters
}
