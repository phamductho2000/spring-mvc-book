package com.webbansach.converter;

import com.webbansach.dto.CategoryDTO;
import com.webbansach.dto.ContactDTO;
import com.webbansach.entity.ContactEntity;
import com.webbansach.entity.ContactEntity;
import org.springframework.stereotype.Component;

@Component
public class ContactConverter {
    public ContactDTO entityToDTO(ContactEntity contactEntity){
        ContactDTO result = new ContactDTO();
        result.setId(contactEntity.getId());
        result.setAddress(contactEntity.getAddress());
        result.setEmail(contactEntity.getEmail());
        result.setPhone(contactEntity.getPhone());
        result.setLink_map(contactEntity.getLink_map());
        result.setLink_fb(contactEntity.getLink_fb());
        result.setLink_insta(contactEntity.getLink_insta());
        result.setLink_youtube(contactEntity.getLink_youtube());
        result.setLink_twitter(contactEntity.getLink_twitter());
        result.setCreated_date(contactEntity.getCreated_date());
        result.setUpdated_date(contactEntity.getUpdated_date());
        result.setCreated_by(contactEntity.getCreated_by());
        result.setModified_by(contactEntity.getModified_by());
        return result;
    }

    public ContactEntity dtoToEntity(ContactDTO contactDTO) {
        ContactEntity result = new ContactEntity();
        result.setAddress(contactDTO.getAddress());
        result.setEmail(contactDTO.getEmail());
        result.setPhone(contactDTO.getPhone());
        result.setLink_map(contactDTO.getLink_map());
        result.setLink_fb(contactDTO.getLink_fb());
        result.setLink_insta(contactDTO.getLink_insta());
        result.setLink_youtube(contactDTO.getLink_youtube());
        result.setLink_twitter(contactDTO.getLink_twitter());
        result.setCreated_date(contactDTO.getCreated_date());
        result.setUpdated_date(contactDTO.getUpdated_date());
        result.setCreated_by(contactDTO.getCreated_by());
        result.setModified_by(contactDTO.getModified_by());
        return result;
    }

    public ContactEntity dtoToEntity(ContactEntity result, ContactDTO contactDTO){
        result.setAddress(contactDTO.getAddress());
        result.setEmail(contactDTO.getEmail());
        result.setPhone(contactDTO.getPhone());
        result.setLink_map(contactDTO.getLink_map());
        result.setLink_fb(contactDTO.getLink_fb());
        result.setLink_insta(contactDTO.getLink_insta());
        result.setLink_youtube(contactDTO.getLink_youtube());
        result.setLink_twitter(contactDTO.getLink_twitter());
        result.setCreated_date(contactDTO.getCreated_date());
        result.setUpdated_date(contactDTO.getUpdated_date());
        result.setCreated_by(contactDTO.getCreated_by());
        result.setModified_by(contactDTO.getModified_by());
        return result;
    }
}
