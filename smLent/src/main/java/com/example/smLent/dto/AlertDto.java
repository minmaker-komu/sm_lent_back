package com.example.smLent.dto;

import com.example.smLent.domain.AlertStatus;

public class AlertDto {
    private Long id;
    private Long itemId;
    private Long lenderId;
    private Long borrowerId;
    private AlertStatus status;

    public AlertDto(Long id, Long itemId, Long lenderId, Long borrowerId, AlertStatus status) {
        this.id = id;
        this.itemId = itemId;
        this.lenderId = lenderId;
        this.borrowerId = borrowerId;
        this.status = status;
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

    // Getters and Setters
}
