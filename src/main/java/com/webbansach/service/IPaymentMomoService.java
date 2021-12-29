package com.webbansach.service;

public interface IPaymentMomoService {

    String sendRequest(long orderId1, int totalPrice) throws Exception;
}
