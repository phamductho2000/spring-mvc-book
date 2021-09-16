package com.webbansach.service.impl;

import com.webbansach.converter.VoucherConverter;
import com.webbansach.dto.VoucherDTO;
import com.webbansach.entity.VoucherEntity;
import com.webbansach.repository.VoucherRepository;
import com.webbansach.service.IVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoucherService implements IVoucherService {

    @Autowired
    VoucherRepository voucherRepository;

    @Autowired
    VoucherConverter voucherConverter;

    @Override
    public int getDiscount(String code){
        VoucherEntity voucherEntity = voucherRepository.findAllByCode(code);
        return voucherEntity.getDiscount();
    }

    @Override
    public List<VoucherDTO> findAll(Pageable pageable) {
        Page<VoucherEntity> voucherEntities =  voucherRepository.findAll(pageable);
        List<VoucherDTO> voucherDTOS = new ArrayList<>();
        for(VoucherEntity item: voucherEntities) {
            VoucherDTO voucherDTO = voucherConverter.entityToDTO(item);
            voucherDTOS.add(voucherDTO);
        }
        return voucherDTOS;
    }

    @Override
    public VoucherDTO findOne(long id) {
        VoucherEntity voucherEntity = voucherRepository.findOne(id);
        VoucherDTO voucherDTO = voucherConverter.entityToDTO(voucherEntity);
        return voucherDTO;
    }

    @Override
    public List<VoucherDTO> search(String code, int discount, int status, String expirationDate, Pageable pageable) {
        List<VoucherEntity> voucherEntities =  voucherRepository.search(code, discount, status, expirationDate, pageable);
        List<VoucherDTO> voucherDTOS = new ArrayList<>();
        for(VoucherEntity item: voucherEntities) {
            VoucherDTO voucherDTO = voucherConverter.entityToDTO(item);
            voucherDTOS.add(voucherDTO);
        }
        return voucherDTOS;
    }

    @Override
    public void save(VoucherDTO voucherDTO){
        VoucherEntity voucherEntity = new VoucherEntity();
        if(voucherDTO.getId() != 0){
            VoucherEntity categoryEntityOld = voucherRepository.findOne(voucherDTO.getId());
            voucherEntity = voucherConverter.dtoToEntity(categoryEntityOld, voucherDTO);
        }
        else{
            voucherEntity = voucherConverter.dtoToEntity(voucherDTO);
        }

        voucherRepository.save(voucherEntity);
    }

    @Override
    public void remove(long id) {
        VoucherEntity voucherEntity = voucherRepository.findOne(id);
        voucherRepository.delete(voucherEntity);
    }

}
