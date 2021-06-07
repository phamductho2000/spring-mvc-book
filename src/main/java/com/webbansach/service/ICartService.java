package com.webbansach.service;

import com.webbansach.dto.CartDTO;

import java.util.HashMap;

public interface ICartService {
    HashMap<Long, CartDTO> addCart(long id, HashMap<Long, CartDTO> cart);

    int totalQuanty(HashMap<Long, CartDTO> cart);

    int totalPrice(HashMap<Long, CartDTO> cart);
}
