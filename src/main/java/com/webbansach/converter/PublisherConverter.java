package com.webbansach.converter;

import com.webbansach.dto.CategoryDTO;
import com.webbansach.dto.PublisherDTO;
import com.webbansach.entity.CategoryEntity;
import com.webbansach.entity.PublisherEntity;
import org.springframework.stereotype.Component;

@Component
public class PublisherConverter {
    public PublisherDTO entityToDTO(PublisherEntity publisherEntity){
        PublisherDTO result = new PublisherDTO();
        result.setId(publisherEntity.getId());
        result.setName(publisherEntity.getName());
        result.setAddress(publisherEntity.getAddress());
        result.setCreated_date(publisherEntity.getCreated_date());
        result.setCreated_by(publisherEntity.getCreated_by());
        result.setModified_by(publisherEntity.getModified_by());
        return result;
    }

    public PublisherEntity dtoToEntity(PublisherDTO publisherDTO) {
        PublisherEntity result = new PublisherEntity();
        result.setName(publisherDTO.getName());
        result.setAddress(publisherDTO.getAddress());
        result.setCreated_date(publisherDTO.getCreated_date());
        result.setCreated_by(publisherDTO.getCreated_by());
        result.setModified_by(publisherDTO.getModified_by());
        return result;
    }

    public PublisherEntity dtoToEntity(PublisherEntity result, PublisherDTO publisherDTO){
        result.setName(publisherDTO.getName());
        result.setAddress(publisherDTO.getAddress());
        result.setCreated_date(publisherDTO.getCreated_date());
        result.setCreated_by(publisherDTO.getCreated_by());
        result.setModified_by(publisherDTO.getModified_by());
        return result;
    }
}
