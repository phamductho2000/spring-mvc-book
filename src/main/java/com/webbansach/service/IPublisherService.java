package com.webbansach.service;

import com.webbansach.dto.BookDTO;
import com.webbansach.dto.PublisherDTO;

import java.util.List;

public interface IPublisherService {
    List<PublisherDTO> findAll();

    PublisherDTO findOne(long id);

    String getNameById(long id);

    void save(PublisherDTO publisherDTO);

    void remove(long id);
}
