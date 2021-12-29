package com.webbansach.service;

import javax.servlet.http.HttpServletRequest;

public interface IPaymentVnpayService {

//    String sendRequest(long orderId1, int totalPrice) throws Exception;

    String sendRequest(long orderId1, int totalPrice, HttpServletRequest request) throws Exception;
}
