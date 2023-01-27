package com.crm.application.Dto;

import com.crm.application.Utils.Validation.Login.ValidLogin;
import com.crm.application.Utils.Validation.Password.ValidPassword;
import com.crm.application.Utils.Validation.UserName.ValidUserName;

import javax.validation.constraints.*;

public class SignUpRequestDto {
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
