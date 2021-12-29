package com.webbansach.service;

import com.webbansach.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IUserService {

    void registerUser(String user, String pass);

    List<UserDTO> findAll(Pageable pageable);

    List<UserDTO> findAllByCurrentDay(Pageable pageable);

    List<UserDTO> findAllByName(String key, Pageable pageable);

    List<UserDTO> findAllByRole(List<String> codes, Pageable pageable);

    UserDTO findOneByUserName(String userName);

    UserDTO findOne(long id);

    void saveCustomer(UserDTO userDTO);

    void saveUser(UserDTO userDTO);

    List<UserDTO> searchUser(String key, int status, String role, Pageable pageable);

    void remove(long id);

    void createPasswordResetTokenForUser(UserDTO userDTO, String token);

    UserDTO findOneByEmail(String email);

    void updatePassword(long userId, String password);

    void sendEmailToResetPassword(String recipientEmail, String link) throws UnsupportedEncodingException, MessagingException;

    void remove(Long[] ids);

    int getTotalItem();
}
