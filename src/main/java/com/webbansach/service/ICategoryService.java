package com.webbansach.service;

import com.webbansach.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> findAll();

    CategoryDTO findOne(long id);

    String getNameById(long id);
}
