package com.webbansach.converter;

import com.webbansach.dto.RoleDTO;
import com.webbansach.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

        public RoleDTO entityToDTO(RoleEntity roleEntity){
            RoleDTO result = new RoleDTO();
            result.setName(roleEntity.getName());
            result.setCode(roleEntity.getCode());
            result.setCreated_date(roleEntity.getCreated_date());
            result.setUpdated_date(roleEntity.getUpdated_date());
            return result;
        }

        public RoleEntity dtoToEntity(RoleDTO roleDTO) {
            RoleEntity result = new RoleEntity();
            result.setCode(roleDTO.getCode());
            result.setName(roleDTO.getName());
            result.setCreated_date(roleDTO.getCreated_date());
            result.setUpdated_date(roleDTO.getUpdated_date());
            return result;
        }

        public RoleEntity dtoToEntity(RoleEntity result, RoleDTO roleDTO){
            result.setCode(roleDTO.getCode());
            result.setName(roleDTO.getName());
            result.setUpdated_date(roleDTO.getUpdated_date());
            return result;
        }
}
