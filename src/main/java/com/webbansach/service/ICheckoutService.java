package com.webbansach.service;

import com.webbansach.dto.CartDTO;
import com.webbansach.entity.DetailOrderEntity;

import java.util.HashMap;

public interface ICheckoutService {

    void saveOrder(HashMap<Long, CartDTO> cart, long userId, int totalPrice);
}
