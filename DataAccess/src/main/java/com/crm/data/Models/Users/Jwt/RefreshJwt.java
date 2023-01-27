package com.crm.data.Models.Users.Jwt;

import com.crm.data.Models.Users.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "refresh_jwt")
public class RefreshJwt implements Serializable {
    @Id
    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @Column(name = "login")
    private String login;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
