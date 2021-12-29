package com.webbansach.service;

import com.webbansach.dto.CategoryDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> findAll();

    List<CategoryDTO> findAll(Pageable pageable);

    List<CategoryDTO> findAllByStatus(int status, Pageable pageable);

    List<CategoryDTO> search(String key, Pageable pageable);

    CategoryDTO findOne(long id);

    String getNameById(long id);

    void save(CategoryDTO categoryDTO);

    void remove(long id);

    void remove(Long[] ids);

    int getTotalItem();
}
