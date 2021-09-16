package com.webbansach.service.impl;

import com.webbansach.converter.CategoryConverter;
import com.webbansach.dto.CategoryDTO;
import com.webbansach.entity.CategoryEntity;
import com.webbansach.repository.CategoryRepository;
import com.webbansach.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryConverter categoryConverter;

    @Override
    public List<CategoryDTO> findAll(){
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for(CategoryEntity item: categoryEntities){
            CategoryDTO categoryDTO = categoryConverter.entityToDTO(item);
            categoryDTOS.add(categoryDTO);
        }
        return categoryDTOS;
    }

    @Override
    public List<CategoryDTO> findAll(Pageable pageable){
        Page<CategoryEntity> categoryEntities = categoryRepository.findAll(pageable);
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for(CategoryEntity item: categoryEntities){
            CategoryDTO categoryDTO = categoryConverter.entityToDTO(item);
            categoryDTOS.add(categoryDTO);
        }
        return categoryDTOS;
    }

    @Override
    public List<CategoryDTO> findAllByStatus(int status, Pageable pageable){
        List<CategoryEntity> categoryEntities = categoryRepository.findAllByStatus(status, pageable);
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for(CategoryEntity item: categoryEntities){
            CategoryDTO categoryDTO = categoryConverter.entityToDTO(item);
            categoryDTOS.add(categoryDTO);
        }
        return categoryDTOS;
    }

    @Override
    public List<CategoryDTO> search(String key, Pageable pageable){
        List<CategoryEntity> categoryEntities = categoryRepository.findAllByNameContaining(key, pageable);
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for(CategoryEntity item: categoryEntities){
            CategoryDTO categoryDTO = categoryConverter.entityToDTO(item);
            categoryDTOS.add(categoryDTO);
        }
        return categoryDTOS;
    }

    @Override
    public CategoryDTO findOne(long id){
        CategoryEntity categoryEntity = categoryRepository.findOne(id);
        CategoryDTO categoryDTO = categoryConverter.entityToDTO(categoryEntity);
        return categoryDTO;
    }

    @Override
    public String getNameById(long id){
        CategoryEntity categoryEntity = categoryRepository.findOne(id);
        String name = categoryEntity.getName();
        return name;
    }
    @Override
    public void save(CategoryDTO categoryDTO){
        CategoryEntity categoryEntity = new CategoryEntity();
        if(categoryDTO.getId() != 0){
            CategoryEntity categoryEntityOld = categoryRepository.findOne(categoryDTO.getId());
            categoryEntity = categoryConverter.dtoToEntity(categoryEntityOld, categoryDTO);
        }
        else{
            categoryEntity = categoryConverter.dtoToEntity(categoryDTO);
        }

        categoryRepository.save(categoryEntity);
    }
    @Override
    public void remove(long id){
        CategoryEntity categoryEntity = categoryRepository.findOne(id);
        categoryRepository.delete(categoryEntity);
    }

    @Override
    public int getTotalItem(){
        return (int) categoryRepository.count();
    }
}
