package com.example.smLent.dto;

public class ItemDto {
    private Long id;
    private String name;
    private int price;
    private String specialNote;

    public ItemDto(Long id, String name, int price, String specialNote) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.specialNote = specialNote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    // Getters and Setters
}
