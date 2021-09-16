package com.webbansach.converter;

import com.webbansach.dto.CategoryDTO;
import com.webbansach.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    public CategoryDTO entityToDTO(CategoryEntity categoryEntity){
        CategoryDTO result = new CategoryDTO();
        result.setId(categoryEntity.getId());
        result.setName(categoryEntity.getName());
        result.setStatus(categoryEntity.getStatus());
        result.setCreated_date(categoryEntity.getCreated_date());
        result.setUpdated_date(categoryEntity.getUpdated_date());
        result.setCreated_by(categoryEntity.getCreated_by());
        result.setModified_by(categoryEntity.getModified_by());
        return result;
    }

    public CategoryEntity dtoToEntity(CategoryDTO categoryDTO) {
        CategoryEntity result = new CategoryEntity();
        result.setName(categoryDTO.getName());
        result.setStatus(categoryDTO.getStatus());
        result.setCreated_date(categoryDTO.getCreated_date());
        result.setUpdated_date(categoryDTO.getUpdated_date());
        result.setCreated_by(categoryDTO.getCreated_by());
        result.setModified_by(categoryDTO.getModified_by());
        return result;
    }

    public CategoryEntity dtoToEntity(CategoryEntity result, CategoryDTO categoryDTO){
        result.setName(categoryDTO.getName());
        result.setStatus(categoryDTO.getStatus());
        result.setUpdated_date(categoryDTO.getUpdated_date());
        result.setCreated_by(categoryDTO.getCreated_by());
        result.setModified_by(categoryDTO.getModified_by());
        return result;
    }
}
