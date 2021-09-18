package com.webbansach.service.impl;

import com.webbansach.converter.UserConverter;
import com.webbansach.dto.UserDTO;
import com.webbansach.dto.UserDTO;
import com.webbansach.entity.BookEntity;
import com.webbansach.entity.PublisherEntity;
import com.webbansach.entity.RoleEntity;
import com.webbansach.entity.UserEntity;
import com.webbansach.repository.RoleRepository;
import com.webbansach.repository.UserRepository;
import com.webbansach.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserConverter userConverter;

    @Override
    public void registerUser(String user, String pass){
        List<RoleEntity> roleEntityList = new ArrayList<>();
        RoleEntity roleEntity = roleRepository.findOneByCode("USER");
        roleEntityList.add(roleEntity);
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userEntity.setPassword(encoder.encode(pass));
        userEntity.setRoles(roleEntityList);
        userRepository.save(userEntity);
    }

    @Override
    public List<UserDTO> findAll(Pageable pageable){
        Page<UserEntity> userEntities =  userRepository.findAll(pageable);
        List<UserDTO> userDTOS = new ArrayList<>();
        for(UserEntity item: userEntities) {
            UserDTO userDTO = userConverter.entityToDTO(item);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public List<UserDTO> findAllByCurrentDay(Pageable pageable){
        List<UserEntity> userEntities =  userRepository.findAllByCurrentDay(pageable);
        List<UserDTO> userDTOS = new ArrayList<>();
        for(UserEntity item: userEntities) {
            UserDTO userDTO = userConverter.entityToDTO(item);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public List<UserDTO> findAllByName(String key, Pageable pageable){
        List<UserEntity> userEntities =  userRepository.findAllByNameContaining(key, pageable);
        List<UserDTO> userDTOS = new ArrayList<>();
        for(UserEntity item: userEntities) {
            UserDTO userDTO = userConverter.entityToDTO(item);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public List<UserDTO> findAllByRole(String code, Pageable pageable){
        List<UserEntity> userEntities =  userRepository.findAllByRole(code, pageable);
        List<UserDTO> userDTOS = new ArrayList<>();
        for(UserEntity item: userEntities) {
            UserDTO userDTO = userConverter.entityToDTO(item);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public UserDTO findOneByUserName(String userName){
        UserEntity userEntity = userRepository.findOneByUsername(userName);
        UserDTO userDTO = userConverter.entityToDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO findOne(long id){
        UserEntity userEntity = userRepository.findOne(id);
        UserDTO userDTO = userConverter.entityToDTO(userEntity);
        return userDTO;
    }

    @Override
    public void saveCustomer(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        if(userDTO.getId() != 0){
            UserEntity userEntityOld = userRepository.findOne(userDTO.getId());
            userEntity = userConverter.dtoToEntity(userEntityOld, userDTO);
        }
        else{
            List<RoleEntity> roleEntityList = new ArrayList<>();
            RoleEntity roleEntity = roleRepository.findOneByCode("USER");
            roleEntityList.add(roleEntity);
            userEntity = userConverter.dtoToEntity(userDTO);
            userEntity.setRoles(roleEntityList);
        }

        userRepository.save(userEntity);
    }

    @Override
    public void saveUser(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        if(userDTO.getId() != 0){
            List<RoleEntity> roleEntityList = new ArrayList<>();
            RoleEntity roleEntity = new RoleEntity();
            for(String s: userDTO.getRoles()){
                roleEntity = roleRepository.findOneByCode(s);
                roleEntityList.add(roleEntity);
            }
            UserEntity userEntityOld = userRepository.findOne(userDTO.getId());
            userEntity = userConverter.dtoToEntity(userEntityOld, userDTO);
            userEntity.setRoles(roleEntityList);
        }
        else{
            List<RoleEntity> roleEntityList = new ArrayList<>();
            RoleEntity roleEntity = new RoleEntity();
            for(String s: userDTO.getRoles()){
                roleEntity = roleRepository.findOneByCode(s);
                roleEntityList.add(roleEntity);
            }
            userEntity = userConverter.dtoToEntity(userDTO);
            userEntity.setRoles(roleEntityList);
        }

        userRepository.save(userEntity);
    }

    @Override
    public  List<UserDTO> searchUser(String key, int status, String role, Pageable pageable){
        List<UserEntity> userEntities = userRepository.search(key, status, role, pageable);
        List<UserDTO> userDTOS = new ArrayList<>();
        for(UserEntity item: userEntities) {
            UserDTO userDTO = userConverter.entityToDTO(item);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public void remove(long id){
        UserEntity userEntity = userRepository.findOne(id);
        userRepository.delete(userEntity);
    }

    @Override
    public int getTotalItem(){return (int) userRepository.count();}
}
