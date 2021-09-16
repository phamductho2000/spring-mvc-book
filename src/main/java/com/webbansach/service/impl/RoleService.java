package com.webbansach.service.impl;

import com.webbansach.converter.RoleConverter;
import com.webbansach.dto.ReviewDTO;
import com.webbansach.dto.RoleDTO;
import com.webbansach.entity.ReviewEntity;
import com.webbansach.entity.RoleEntity;
import com.webbansach.repository.RoleRepository;
import com.webbansach.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleConverter roleConverter;

    @Override
    public List<RoleDTO> findAllRole(){
        List<RoleEntity> roleEntities = roleRepository.findAll();
        List<RoleDTO> roleDTOS = new ArrayList<>();
        for(RoleEntity item: roleEntities) {
            RoleDTO roleDTO = roleConverter.entityToDTO(item);
            roleDTOS.add(roleDTO);
        }
        return roleDTOS;
    }

    @Override
    public List<String> getAllRole() {
        List<String> roles = roleRepository.getAllCode();
        return roles;
    }
}
