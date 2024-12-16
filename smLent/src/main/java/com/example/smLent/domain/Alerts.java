package com.example.smLent.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
public class Alerts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private Long id; // 알림 ID (PK)

    @ManyToOne
    @JoinColumn(name = "item_fk", nullable = false)
    private Item item; // 물건 (FK)

    @ManyToOne
    @JoinColumn(name = "user_L_fk", referencedColumnName = "id")
    private Member lender; // 빌려주는 사람 (FK)

    @ManyToOne
    @JoinColumn(name = "user_B_fk", referencedColumnName = "id")
    private Member borrower; // 빌리는 사람 (FK)


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('승인', '거절', '대기') DEFAULT '대기'")
    private AlertStatus status; // 상태 (승인, 거절, 대기)

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt; // 생성 시간

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Alerts() {
    }

    public Alerts(Long id, Item item, Member lender, Member borrower, AlertStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.item = item;
        this.lender = lender;
        this.borrower = borrower;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Member getLender() {
        return lender;
    }

    public void setLender(Member lender) {
        this.lender = lender;
    }

    public Member getBorrower() {
        return borrower;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
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
}
