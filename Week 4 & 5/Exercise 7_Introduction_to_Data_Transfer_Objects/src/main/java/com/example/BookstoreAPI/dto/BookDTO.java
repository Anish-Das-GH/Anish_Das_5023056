package com.example.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private double price;
    private String isbn;

    public BookDTO() {}

    public BookDTO(Long id, String title, String author, double price, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    @JsonProperty("bookId")
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @JsonProperty("bookTitle")
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @JsonProperty("bookAuthor")
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @JsonProperty("bookPrice")
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @JsonProperty("bookIsbn")
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
}
