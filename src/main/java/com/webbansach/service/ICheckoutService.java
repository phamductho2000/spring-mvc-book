package com.webbansach.service;

import com.webbansach.dto.CartDTO;

import java.util.HashMap;

public interface ICheckoutService {

     void saveOrder(HashMap<Long, CartDTO> cart, long userId, String paymentCode, int totalPrice);

     long saveOrderReturnId(HashMap<Long, CartDTO> cart, long userId, String paymentCode, int totalPrice);
}
