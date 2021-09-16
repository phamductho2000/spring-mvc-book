package com.webbansach.service;

import com.webbansach.dto.CartDTO;

import java.util.HashMap;
import java.util.Map;

public interface ICartService {
    HashMap<Long, CartDTO> addCart(long id, int quantity, HashMap<Long, CartDTO> cart);

    HashMap<Long, CartDTO> editCart(int[] quantys, HashMap<Long, CartDTO> cart);

    void deleteItemCart(long id, HashMap<Long, CartDTO> cart);

    int totalQuanty(HashMap<Long, CartDTO> cart);

    int totalPrice(HashMap<Long, CartDTO> cart);
}
