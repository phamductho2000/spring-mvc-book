package com.webbansach.service.impl;

import com.webbansach.converter.PaymentConverter;
import com.webbansach.dto.PaymentDTO;
import com.webbansach.entity.PaymentEntity;
import com.webbansach.repository.PaymentRepository;
import com.webbansach.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentConverter paymentConverter;


    @Override
    public List<PaymentDTO> findAll(long id, Pageable pageable) {
        Page<PaymentEntity> paymentEntities =  paymentRepository.findAll(pageable);
        List<PaymentDTO> paymentDTOS = new ArrayList<>();
        for(PaymentEntity item: paymentEntities) {
            PaymentDTO paymentDTO = paymentConverter.entityToDTO(item);
            paymentDTOS.add(paymentDTO);
        }
        return paymentDTOS;
    }

    @Override
    public PaymentDTO findOne(long id) {
        PaymentEntity paymentEntity = paymentRepository.findOne(id);
        PaymentDTO paymentDTO = paymentConverter.entityToDTO(paymentEntity);
        return paymentDTO;
    }

    @Override
    public PaymentDTO findByCode(String code) {
        PaymentEntity paymentEntity = paymentRepository.findByCode(code);
        PaymentDTO paymentDTO = paymentConverter.entityToDTO(paymentEntity);
        return paymentDTO;
    }

}
