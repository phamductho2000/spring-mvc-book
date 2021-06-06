package com.webbansach.service;

import com.webbansach.dto.BookDTO;
import com.webbansach.entity.BookEntity;
import org.springframework.ui.Model;

import java.util.List;

public interface IBookService {

    List<BookDTO> findAll();

    BookDTO findOne(long id);

    List<BookDTO> findAllByCateId(long id);

    void save(BookDTO bookDTO);

    void remove(long id);

}
