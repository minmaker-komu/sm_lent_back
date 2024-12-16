package com.example.smLent.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 회원 PK

    @Column(nullable = false, unique = true)
    private String username; // 아이디

    @Column(nullable = false)
    private String password; // 비밀번호

    @OneToMany(mappedBy = "lender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alerts> lentAlerts; // 빌려준 알림

    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alerts> borrowedAlerts; // 빌린 알림

    public Member(Long id, String username, String password, List<Alerts> lentAlerts, List<Alerts> borrowedAlerts) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lentAlerts = lentAlerts;
        this.borrowedAlerts = borrowedAlerts;
    }

    public Member() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Alerts> getLentAlerts() {
        return lentAlerts;
    }

    public void setLentAlerts(List<Alerts> lentAlerts) {
        this.lentAlerts = lentAlerts;
    }

    public List<Alerts> getBorrowedAlerts() {
        return borrowedAlerts;
    }

    public void setBorrowedAlerts(List<Alerts> borrowedAlerts) {
        this.borrowedAlerts = borrowedAlerts;
    }


    // Getters and Setters
}


