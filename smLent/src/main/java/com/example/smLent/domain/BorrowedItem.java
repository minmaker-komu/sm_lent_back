package com.example.smLent.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrowed_item")
public class BorrowedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 빌린 물건 PK

    @ManyToOne
    @JoinColumn(name = "item_fk", nullable = false)
    private Item item; // 물건 (FK)

    @ManyToOne
    @JoinColumn(name = "member_fk", nullable = false)
    private Member member; // 사용자 ID (FK)

    private String specialNote; // 특별사항메시지

    @Column(name = "borrowed_time", nullable = false)
    private LocalDateTime borrowedTime; // 빌린 시간

    @PrePersist
    protected void onCreate() {
        this.borrowedTime = LocalDateTime.now();
    }

    public BorrowedItem(Long id, Item item, Member member, String specialNote, LocalDateTime borrowedTime) {
        this.id = id;
        this.item = item;
        this.member = member;
        this.specialNote = specialNote;
        this.borrowedTime = borrowedTime;
    }

    public BorrowedItem() {
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

    // Getters and Setters
}
