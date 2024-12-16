package com.example.smLent.dto;

import com.example.smLent.domain.AlertStatus;
import java.time.LocalDateTime;

public class AlertDto {

    private Long id;
    private Long itemId;
    private Long lenderId;
    private Long borrowerId;
    private AlertStatus status;
    private LocalDateTime createdAt;

    // 기본 생성자
    public AlertDto() {}

    public AlertDto(Long id, Long itemId, Long lenderId, Long borrowerId, AlertStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.itemId = itemId;
        this.lenderId = lenderId;
        this.borrowerId = borrowerId;
        this.status = status;
        this.createdAt = createdAt;
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

    public Long getLenderId() {
        return lenderId;
    }

    public void setLenderId(Long lenderId) {
        this.lenderId = lenderId;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public AlertStatus getStatus() {
        return status;
    }

    public void setStatus(AlertStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Getters and Setters
    // ...
}
