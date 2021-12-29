package com.webbansach.service.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.webbansach.hmac.HMac;
import com.webbansach.service.IPaymentMomoService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PaymentMomoService implements IPaymentMomoService {

    final String SECRET_KEY = "0d3UiM5tGjiPXmaUEhvMMOnaH2UdEBds";
    final String ENDPOINT_MOMO = "https://test-payment.momo.vn/gw_payment/transactionProcessor";
    final String PARTNER_CODE = "MOMOL9MQ20210924";
    final String ACCESS_KEY = "AwXDmymXc4xrBqu7";

    private RestTemplate restTemplate;
    private HttpHeaders headers;

    public String sendRequest(long orderId1, int totalPrice) throws Exception {
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime dateTimeNow = LocalDateTime.now();

        String secretKey = SECRET_KEY;
        String endPointMomo = ENDPOINT_MOMO;
        String partnerCode = PARTNER_CODE;
        String accessKey = ACCESS_KEY;
        String amount = String.valueOf(totalPrice);
        String orderId = String.valueOf(orderId1);
        String requestId = "ABC123";
        String orderInfo = "DH" + dtf.format(dateTimeNow);
        String returnUrl = "http://localhost:8080/thanh-cong";
        String notifyUrl = "http://localhost:8080/thanh-cong";
        String extraData = "";
        String rawHash =
                "partnerCode=" + partnerCode +
                        "&accessKey=" + accessKey +
                        "&requestId=" + requestId +
                        "&amount=" + amount +
                        "&orderId=" + orderId +
                        "&orderInfo=" + orderInfo +
                        "&returnUrl=" + returnUrl +
                        "&notifyUrl=" + notifyUrl +
                        "&extraData=" + extraData;

        HMac sha256 = new HMac();
        String signature = sha256.calculateHMac(rawHash, secretKey);

        JsonObject message = new JsonObject();
        message.addProperty("accessKey", accessKey);
        message.addProperty("partnerCode", partnerCode);
        message.addProperty("requestType", "captureMoMoWallet");
        message.addProperty("notifyUrl", notifyUrl);
        message.addProperty("returnUrl", returnUrl);
        message.addProperty("orderId", orderId);
        message.addProperty("amount", amount);
        message.addProperty("orderInfo", orderInfo);
        message.addProperty("requestId", requestId);
        message.addProperty("extraData", extraData);
        message.addProperty("signature", signature);

        HttpEntity<String> request = new HttpEntity<>(message.toString(), headers);
        String responseFromMomo = restTemplate.postForObject(endPointMomo, request, String.class);
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(responseFromMomo).getAsJsonObject();
        String urlResult = result.get("payUrl").getAsString();

        return urlResult;
    }
}
