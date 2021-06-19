package com.webbansach.service.impl;

import com.webbansach.converter.PublisherConverter;
import com.webbansach.dto.PublisherDTO;
import com.webbansach.entity.PublisherEntity;
import com.webbansach.repository.PublisherRepository;
import com.webbansach.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherService implements IPublisherService {
    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    PublisherConverter publisherConverter;

    @Override
    public List<PublisherDTO> findAll(){
        List<PublisherEntity> publisherEntities = publisherRepository.findAll();
        List<PublisherDTO> publisherDTOS = new ArrayList<>();
        for(PublisherEntity item: publisherEntities){
            PublisherDTO publisherDTO = publisherConverter.entityToDTO(item);
            publisherDTOS.add(publisherDTO);
        }
        return publisherDTOS;
    }

    @Override
    public PublisherDTO findOne(long id){
        PublisherEntity publisherEntity = publisherRepository.findOne(id);
        PublisherDTO publisherDTO = publisherConverter.entityToDTO(publisherEntity);
        return publisherDTO;
    }

    @Override
    public String getNameById(long id){
        PublisherEntity publisherEntity = publisherRepository.findOne(id);
        String name = publisherEntity.getName();
        return name;
    }

    @Override
    public void save(PublisherDTO publisherDTO){
        PublisherEntity publisherEntity = new PublisherEntity();
        if(publisherDTO.getId() != null){
            PublisherEntity publisherEntityOld = publisherRepository.findOne(publisherDTO.getId());
            publisherEntity = publisherConverter.dtoToEntity(publisherEntityOld, publisherDTO);
        }
        else{
            publisherEntity = publisherConverter.dtoToEntity(publisherDTO);
        }

        publisherRepository.save(publisherEntity);
    }
    @Override
    public void remove(long id){
        PublisherEntity publisherEntity = publisherRepository.findOne(id);
        publisherRepository.delete(publisherEntity);
    }
}
