package com.webbansach.service;

import com.webbansach.dto.PaymentDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPaymentService {
    List<PaymentDTO> findAll(long id, Pageable pageable);

    PaymentDTO findOne(long id);

    PaymentDTO findByCode(String code);
}
