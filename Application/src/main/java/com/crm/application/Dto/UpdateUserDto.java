package com.crm.application.Dto;

import com.crm.application.Validation.Login.ValidLogin;
import com.crm.application.Validation.Password.ValidPassword;
import com.crm.application.Validation.UserName.ValidUserName;

import javax.validation.constraints.NotNull;

public class UpdateUserDto {
    @NotNull
    @ValidUserName
    public String name;

    @NotNull
    @ValidLogin
    public String login;

    @NotNull
    @ValidPassword
    public String password;
}