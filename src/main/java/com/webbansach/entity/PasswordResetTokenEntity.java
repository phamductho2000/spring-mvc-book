package com.webbansach.entity;

import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "db_password_reset_token")
public class PasswordResetTokenEntity extends BaseEntity{

    @Column(name = "token")
    private String token;
    @Column(name = "expried_date")
    private Date exprie_date;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "user_id")
    private UserEntity user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExprie_date() {
        return exprie_date;
    }

    public void setExprie_date(Date exprie_date) {
        this.exprie_date = exprie_date;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
