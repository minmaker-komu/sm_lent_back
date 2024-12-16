package com.example.smLent.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lent_item")
public class LentItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 빌려준 물건 PK

    @ManyToOne
    @JoinColumn(name = "item_fk", nullable = false)
    private Item item; // 물건 (FK)

    @ManyToOne
    @JoinColumn(name = "member_fk", nullable = false)
    private Member member; // 사용자 ID (FK)

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt; // 올린 시간

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public LentItem() {
    }

    public LentItem(Long id, Item item, Member member, LocalDateTime createdAt) {
        this.id = id;
        this.item = item;
        this.member = member;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Getters and Setters
}
