package com.webbansach.service;

import com.webbansach.dto.PublisherDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPublisherService {
    List<PublisherDTO> findAll();

    List<PublisherDTO> findAll(Pageable pageable);

    List<PublisherDTO> findAllByCateId(long cateId, Pageable pageable);

    List<PublisherDTO> search(String name, String address, Pageable pageable);

    PublisherDTO findOne(long id);

    String getNameById(long id);

    void save(PublisherDTO publisherDTO);

    void remove(long id);

    void remove(Long[] ids);

    int getTotalItem();
}
