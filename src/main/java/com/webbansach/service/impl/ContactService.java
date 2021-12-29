package com.webbansach.service.impl;

import com.webbansach.converter.ContactConverter;
import com.webbansach.dto.ContactDTO;
import com.webbansach.entity.ContactEntity;
import com.webbansach.repository.ContactRepository;
import com.webbansach.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService implements IContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactConverter contactConverter;

    @Override
    public List<ContactDTO> findAll(Pageable pageable){
        Page<ContactEntity> contactEntities = contactRepository.findAll(pageable);
        List<ContactDTO> contactDTOS = new ArrayList<>();
        for(ContactEntity item: contactEntities){
            ContactDTO contactDTO = contactConverter.entityToDTO(item);
            contactDTOS.add(contactDTO);
        }
        return contactDTOS;
    }

    @Override
    public ContactDTO findOne(){
        ContactEntity contactEntity = contactRepository.findFirstByOrderByAddressAsc();
        ContactDTO contactDTO = contactConverter.entityToDTO(contactEntity);
        return contactDTO;
    }

    @Override
    public void save(ContactDTO contactDTO){
        ContactEntity contactEntity = new ContactEntity();
        if(contactDTO.getId() != 0){
            ContactEntity categoryEntityOld = contactRepository.findOne(contactDTO.getId());
            contactEntity = contactConverter.dtoToEntity(categoryEntityOld, contactDTO);
        }
        else{
            contactEntity = contactConverter.dtoToEntity(contactDTO);
        }

        contactRepository.save(contactEntity);
    }
}
