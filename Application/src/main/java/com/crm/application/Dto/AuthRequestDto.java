package com.crm.application.Dto;

import com.crm.application.Utils.Validation.Login.ValidLogin;
import com.crm.application.Utils.Validation.Password.ValidPassword;

import javax.validation.constraints.NotNull;

public class AuthRequestDto {
    @NotNull
    @ValidLogin
    public String login;

    @NotNull
    @ValidPassword
    public String password;

    public AuthRequestDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public AuthRequestDto() {
    }
}
