package com.example.smLent.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "completed_item")
public class CompletedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 성사된 물건 PK

    @ManyToOne
    @JoinColumn(name = "item_fk", nullable = false)
    private Item item; // 물건 이름 (FK)

    @ManyToOne
    @JoinColumn(name = "lender_fk", nullable = false)
    private Member lender; // 빌려준 사람 (FK)

    @ManyToOne
    @JoinColumn(name = "borrower_fk", nullable = false)
    private Member borrower; // 빌린 사람 (FK)

    public CompletedItem(Long id, Item item, Member lender, Member borrower) {
        this.id = id;
        this.item = item;
        this.lender = lender;
        this.borrower = borrower;
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


    // Getters and Setters
}
