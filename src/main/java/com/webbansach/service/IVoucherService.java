package com.webbansach.service;

import com.webbansach.dto.VoucherDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IVoucherService {
    int getDiscount(String code);

    List<VoucherDTO> findAll(Pageable pageable);

    VoucherDTO findOne(long id);

    List<VoucherDTO> search(String code, int discount, int status, String expirationDate, Pageable pageable);

    void save(VoucherDTO voucherDTO);

    void remove(long id);
}
