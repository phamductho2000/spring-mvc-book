package com.webbansach.service.impl;

import com.webbansach.entity.PasswordResetTokenEntity;
import com.webbansach.repository.PasswordResetTokenRepository;
import com.webbansach.service.IPasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetTokenService implements IPasswordResetTokenService {

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public PasswordResetTokenEntity findByToken(String token){
        PasswordResetTokenEntity passwordResetTokenEntity = passwordResetTokenRepository.findByToken(token);
        return passwordResetTokenEntity;
    }
}
