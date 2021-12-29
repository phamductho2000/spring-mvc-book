package com.webbansach.service;

import com.webbansach.dto.ContactDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContactService {
    List<ContactDTO> findAll(Pageable pageable);

    ContactDTO findOne();

    void save(ContactDTO contactDTO);
}
