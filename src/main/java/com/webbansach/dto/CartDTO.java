package com.webbansach.dto;

public class CartDTO {
    private BookDTO book;
    private int quanty;
    private int totalPrice;

    public CartDTO() {

    }

    public CartDTO(BookDTO book, int quanty, int totalPrice) {
        this.book = book;
        this.quanty = quanty;
        this.totalPrice = totalPrice;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public int getQuanty() {
        return quanty;
    }

    public void setQuanty(int quanty) {
        this.quanty = quanty;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

}
