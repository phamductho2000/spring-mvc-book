package com.webbansach.service;

import com.webbansach.entity.PasswordResetTokenEntity;

public interface IPasswordResetTokenService {
    PasswordResetTokenEntity findByToken(String token);
}
