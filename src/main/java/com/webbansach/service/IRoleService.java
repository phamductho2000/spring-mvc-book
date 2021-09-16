package com.webbansach.service;

import com.webbansach.dto.RoleDTO;

import java.util.List;

public interface IRoleService {

    List<RoleDTO> findAllRole();

    List<String> getAllRole();
}
