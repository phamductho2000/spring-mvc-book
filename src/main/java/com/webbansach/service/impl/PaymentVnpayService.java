package com.webbansach.service.impl;

import com.webbansach.hmac.Sha512;
import com.webbansach.service.IPaymentVnpayService;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
public class PaymentVnpayService implements IPaymentVnpayService {

    final String VNP_TMNCODE = "UK1Z5PH6";
    final static String VNP_HASHSECRET = "SVMZJPCXZTZGNEOWTZIXGGKWYZMEKGTA";
    final String VNP_URL = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html?";
    final String VNP_VERSION = "2.1.0";
    final String VNP_COMMAND = "pay";
    final String ORDER_TYPE = "150000";

    @Override
    public String sendRequest(long orderId1, int totalPrice, HttpServletRequest request) throws Exception {
        //vnp_Command = querydr
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime dateTimeNow = LocalDateTime.now();
        String vnp_TxnRef = String.valueOf(orderId1);
        String vnp_TmnCode = VNP_TMNCODE;
        String vnp_IpAddr = "127.0.0.1";

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", VNP_VERSION);
        vnp_Params.put("vnp_Command", VNP_COMMAND);
        vnp_Params.put("vnp_Amount", String.valueOf(totalPrice * 100));
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Kiem tra ket qua GD OrderId:" + vnp_TxnRef);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
        vnp_Params.put("vnp_CurrCode", "VND");
        vnp_Params.put("vnp_ReturnUrl", "http://localhost:8080/VnPayReturn");
        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_OrderType", ORDER_TYPE);
        vnp_Params.put("vnp_CreateDate", dtf.format(dateTimeNow));
        //Build data to hash and querystring
        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));

                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        Sha512 sha512 = new Sha512();
        String queryUrl = query.toString();
        String vnp_SecureHash = sha512.calculateHMac(VNP_HASHSECRET, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = VNP_URL + queryUrl;

        return paymentUrl;
    }


}
