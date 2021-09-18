package com.webbansach.converter;

import com.webbansach.dto.UserDTO;
import com.webbansach.entity.RoleEntity;
import com.webbansach.entity.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    public UserDTO entityToDTO(UserEntity userEntity){
        UserDTO result = new UserDTO();
        List<String> roles = new ArrayList<>();
        result.setId(userEntity.getId());
        result.setName(userEntity.getName());
        result.setEmail(userEntity.getEmail());
        result.setAvatar(userEntity.getAvatar());
        result.setAddress(userEntity.getAddress());
        result.setUsername(userEntity.getUsername());
        result.setPassword(userEntity.getPassword());
        result.setStatus(userEntity.getStatus());
        List<RoleEntity> roleEntities = userEntity.getRoles();
        for(RoleEntity item: roleEntities){
            roles.add(item.getCode());
        }
        result.setRoles(roles);
        result.setPhone(userEntity.getPhone());
        result.setCreated_date(userEntity.getCreated_date());
        result.setUpdated_date(userEntity.getUpdated_date());
        return result;
    }

    public UserEntity dtoToEntity(UserDTO userDTO) {
        UserEntity result = new UserEntity();
        result.setName(userDTO.getName());
        result.setEmail(userDTO.getEmail());
        result.setAddress(userDTO.getAddress());
        result.setPhone(userDTO.getPhone());
        result.setUsername(userDTO.getUsername());
        result.setStatus(userDTO.getStatus());
        if(userDTO.getAvatar() != ""){
            result.setAvatar(userDTO.getAvatar());
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        result.setPassword(encoder.encode(userDTO.getPassword()));
        result.setCreated_date(userDTO.getCreated_date());
        result.setUpdated_date(userDTO.getUpdated_date());
        return result;
    }

    public UserEntity dtoToEntity(UserEntity result, UserDTO userDTO){
        result.setName(userDTO.getName());
        result.setPhone(userDTO.getPhone());
        result.setEmail(userDTO.getEmail());
        result.setAddress(userDTO.getAddress());
        result.setStatus(userDTO.getStatus());
        if(userDTO.getAvatar() != ""){
            result.setAvatar(userDTO.getAvatar());
        }
       if(userDTO.getPassword().equals("") == false){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            result.setPassword(encoder.encode(userDTO.getPassword()));
        }
        result.setUpdated_date(userDTO.getUpdated_date());
        return result;
    }
}
