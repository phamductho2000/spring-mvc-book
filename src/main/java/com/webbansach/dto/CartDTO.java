package com.webbansach.dto;

import com.webbansach.entity.BookEntity;

import java.util.ArrayList;

public class CartDTO {
    private BookDTO book;
    private int quanty;
    private double totalPrice;

    public CartDTO() {

    }

    public CartDTO(BookDTO book, int quanty, double totalPrice) {
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
