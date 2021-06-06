package com.webbansach.service.impl;

import com.webbansach.dto.BookDTO;
import com.webbansach.dto.CartDTO;
import com.webbansach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class CartService {

    @Autowired
    IBookService bookService;

    public HashMap<Long, CartDTO> addCart(long id, HashMap<Long, CartDTO> cart){
        CartDTO itemCart = new CartDTO();
        BookDTO book = bookService.findOne(id);
        if(book != null){
            itemCart = cart.get(id);
            itemCart.setQuanty(itemCart.getQuanty() + 1);
            itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getBook().getPrice());
        }
        else{
            itemCart.setBook(book);
            itemCart.setQuanty(1);
            itemCart.setTotalPrice(book.getPrice());
        }
        cart.put(id, itemCart);
        return cart;
    }
}
