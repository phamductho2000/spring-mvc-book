package com.webbansach.converter;

import com.webbansach.dto.VoucherDTO;
import com.webbansach.entity.VoucherEntity;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class VoucherConverter {
    public VoucherDTO entityToDTO(VoucherEntity voucherEntity){
        VoucherDTO result = new VoucherDTO();
        result.setId(voucherEntity.getId());
        result.setCode(voucherEntity.getCode());
        result.setDiscount(voucherEntity.getDiscount());
        result.setDescription(voucherEntity.getDescription());
        result.setStatus(voucherEntity.getStatus());
        result.setExpirationDate(voucherEntity.getExpiration_date());
        result.setCreated_date(voucherEntity.getCreated_date());
        result.setUpdated_date(voucherEntity.getUpdated_date());
        result.setCreated_by(voucherEntity.getCreated_by());
        result.setModified_by(voucherEntity.getModified_by());
        return result;
    }

    public VoucherEntity dtoToEntity(VoucherDTO voucherDTO) {
        VoucherEntity result = new VoucherEntity();
        result.setCode(voucherDTO.getCode());
        result.setDiscount(voucherDTO.getDiscount());
        result.setDescription(voucherDTO.getDescription());
        result.setStatus(voucherDTO.getStatus());
        result.setExpiration_date(voucherDTO.getExpirationDate());
        result.setCreated_date(voucherDTO.getCreated_date());
        result.setUpdated_date(voucherDTO.getUpdated_date());
        result.setCreated_by(voucherDTO.getCreated_by());
        result.setModified_by(voucherDTO.getModified_by());
        return result;
    }

    public VoucherEntity dtoToEntity(VoucherEntity result, VoucherDTO voucherDTO){
        result.setCode(voucherDTO.getCode());
        result.setDiscount(voucherDTO.getDiscount());
        result.setDescription(voucherDTO.getDescription());
        result.setStatus(voucherDTO.getStatus());
        result.setExpiration_date(voucherDTO.getExpirationDate());
        result.setUpdated_date(voucherDTO.getUpdated_date());
        result.setModified_by(voucherDTO.getModified_by());
        return result;
    }
}
