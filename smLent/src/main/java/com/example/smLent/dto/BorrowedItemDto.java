package com.example.smLent.dto;

import java.time.LocalDateTime;

public class BorrowedItemDto {
    private Long id; // 빌린 아이템 ID
    private Long itemId; // 물건 ID
    private Long memberId; // 사용자 ID
    private String itemName; // 물건 이름
    private int price; // 물건 가격
    private String specialNote; // 특별사항
    private LocalDateTime borrowedTime; // 빌린 시간

    public BorrowedItemDto() {
    }

    public BorrowedItemDto(Long id, Long itemId, Long memberId, String itemName, int price, String specialNote, LocalDateTime borrowedTime) {
        this.id = id;
        this.itemId = itemId;
        this.memberId = memberId;
        this.itemName = itemName;
        this.price = price;
        this.specialNote = specialNote;
        this.borrowedTime = borrowedTime;
    }

    public BorrowedItemDto(Long id, Long itemId, String itemName, int price, String specialNote, LocalDateTime borrowedTime) {
        this.id = id;
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.specialNote = specialNote;
        this.borrowedTime = borrowedTime;
    }

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

    public LocalDateTime getBorrowedTime() {
        return borrowedTime;
    }

    public void setBorrowedTime(LocalDateTime borrowedTime) {
        this.borrowedTime = borrowedTime;
    }
}
