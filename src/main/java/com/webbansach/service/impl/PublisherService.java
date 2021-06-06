package com.webbansach.service.impl;

import com.webbansach.dto.BookDTO;
import com.webbansach.dto.PublisherDTO;
import com.webbansach.entity.BookEntity;
import com.webbansach.entity.CategoryEntity;
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

    @Override
    public List<PublisherDTO> findAll(){
        List<PublisherEntity> publisherEntities = publisherRepository.findAll();
        List<PublisherDTO> publisherDTOS = new ArrayList<>();
        for(PublisherEntity item: publisherEntities){
            PublisherDTO publisherDTO = new PublisherDTO();
            publisherDTO.setId(item.getId());
            publisherDTO.setName(item.getName());
            publisherDTO.setAddress(item.getAddress());
            publisherDTO.setCreated_date(item.getCreated_date());
            publisherDTOS.add(publisherDTO);
        }
        return publisherDTOS;
    }

    @Override
    public PublisherDTO findOne(long id){
        PublisherEntity publisherEntity = publisherRepository.findOne(id);
        PublisherDTO publisherDTO = new PublisherDTO();
            publisherDTO.setId(publisherEntity.getId());
            publisherDTO.setName(publisherEntity.getName());
            publisherDTO.setAddress(publisherEntity.getAddress());
            publisherDTO.setCreated_date(publisherEntity.getCreated_date());

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
       PublisherEntity publisher = new PublisherEntity();
       publisher.setName(publisherDTO.getName());
       publisher.setAddress(publisherDTO.getAddress());
       publisherRepository.save(publisher);
    }

    @Override
    public void update(PublisherDTO publisherDTO){
        PublisherEntity publisherEntity = publisherRepository.findOne(publisherDTO.getId());
        publisherEntity.setName(publisherDTO.getName());
        publisherEntity.setAddress(publisherDTO.getAddress());
        publisherRepository.save(publisherEntity);
    }
}
