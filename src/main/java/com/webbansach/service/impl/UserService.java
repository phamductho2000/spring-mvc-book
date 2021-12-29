package com.webbansach.service.impl;

import com.webbansach.converter.UserConverter;
import com.webbansach.dto.UserDTO;
import com.webbansach.entity.*;
import com.webbansach.repository.PasswordResetTokenRepository;
import com.webbansach.repository.RoleRepository;
import com.webbansach.repository.UserRepository;
import com.webbansach.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void registerUser(String user, String pass){
        List<RoleEntity> roleEntityList = new ArrayList<>();
        RoleEntity roleEntity = roleRepository.findOneByCode("USER");
        roleEntityList.add(roleEntity);
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userEntity.setPassword(encoder.encode(pass));
        userEntity.setStatus(1);
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
    public List<UserDTO> findAllByRole(List<String> codes, Pageable pageable){
        List<UserEntity> userEntities =  userRepository.findAllByRole(codes, pageable);
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
    public void createPasswordResetTokenForUser(UserDTO userDTO, String token){
        PasswordResetTokenEntity passwordResetTokenEntity = new PasswordResetTokenEntity();
        UserEntity userEntity = userRepository.findOne(userDTO.getId());
        passwordResetTokenEntity.setUser(userEntity);
        passwordResetTokenEntity.setToken(token);
        passwordResetTokenRepository.save(passwordResetTokenEntity);
    }

    @Override
    public UserDTO findOneByEmail(String email){
        UserDTO userDTO = new UserDTO();
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity != null){
            userDTO = userConverter.entityToDTO(userEntity);
        }
        else {
            userDTO = null;
        }
        return userDTO;
    }

    @Override
    public void updatePassword(long userId, String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserEntity userEntity = userRepository.findOne(userId);
        userEntity.setPassword(encoder.encode(password));
        userRepository.save(userEntity);
    }

    @Override
    public void sendEmailToResetPassword(String recipientEmail, String link) throws UnsupportedEncodingException, MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("tho2022000@gmail.com", "Store book support");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }

    @Override
    public void remove(Long[] ids){
        userRepository.removeUsersByIds(Arrays.asList((ids)));
    }

    @Override
    public int getTotalItem(){return (int) userRepository.count();}
}
