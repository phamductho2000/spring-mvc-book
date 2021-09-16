package com.webbansach.dto;

public class WishlistDTO extends AbstractDTO<WishlistDTO>{

    private BookDTO book;
    private UserDTO user;

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
