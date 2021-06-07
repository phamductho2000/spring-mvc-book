package com.webbansach.service.impl;

import com.webbansach.dto.BookDTO;
import com.webbansach.dto.CartDTO;
import com.webbansach.service.IBookService;
import com.webbansach.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;

@Service
public class CartService implements ICartService {

    @Autowired
    IBookService bookService;

    @Override
    public HashMap<Long, CartDTO> addCart(long id, HashMap<Long, CartDTO> cart){
        CartDTO itemCart = new CartDTO();
        BookDTO book = bookService.findOne(id);
        if(book != null && cart.containsKey(id)){
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

    @Override
    public int totalQuanty(HashMap<Long, CartDTO> cart){
        int totalQuanty = 0;
        Set<Long> keySet = cart.keySet();
        for (Long key : keySet) {
            totalQuanty += cart.get(key).getQuanty();
        }
        return totalQuanty;
    }

    @Override
    public int totalPrice(HashMap<Long, CartDTO> cart){
        int totalPrice = 0;
        Set<Long> keySet = cart.keySet();
        for (Long key : keySet) {
            totalPrice += cart.get(key).getTotalPrice();
        }
        return totalPrice;
    }
}
