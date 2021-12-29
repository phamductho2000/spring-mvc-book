package com.webbansach.converter;

import com.webbansach.dto.PaymentDTO;
import com.webbansach.entity.PaymentEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverter {
    public PaymentDTO entityToDTO(PaymentEntity paymentEntity){
        PaymentDTO result = new PaymentDTO();
        result.setId(paymentEntity.getId());
        result.setCode(paymentEntity.getCode());
        result.setName(paymentEntity.getName());
        result.setStatus(paymentEntity.getStatus());
        result.setCreated_date(paymentEntity.getCreated_date());
        result.setUpdated_date(paymentEntity.getUpdated_date());
        return result;
    }

    public PaymentEntity dtoToEntity(PaymentDTO paymentDTO) {
        PaymentEntity result = new PaymentEntity();
        result.setCode(paymentDTO.getCode());
        result.setName(paymentDTO.getName());
        result.setStatus(paymentDTO.getStatus());
        result.setCreated_date(paymentDTO.getCreated_date());
        result.setUpdated_date(paymentDTO.getUpdated_date());
        return result;
    }

    public PaymentEntity dtoToEntity(PaymentEntity result, PaymentDTO paymentDTO){
        result.setCode(paymentDTO.getCode());
        result.setName(paymentDTO.getName());
        result.setStatus(paymentDTO.getStatus());
        result.setCreated_date(paymentDTO.getCreated_date());
        result.setUpdated_date(paymentDTO.getUpdated_date());
        return result;
    }
}
