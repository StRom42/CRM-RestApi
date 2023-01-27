package com.crm.application.Contracts;

import com.crm.application.Dto.SignUpRequestDto;
import com.crm.application.Dto.UpdateUserRequestDto;
import com.crm.application.Utils.Exceptions.Auth.Duplicate.UserDuplicateException;
import com.crm.data.Models.Users.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface IUserService extends UserDetailsService {
    void addUser(SignUpRequestDto signUpRequestDto) throws UserDuplicateException;
    void updateUser(User user, UpdateUserRequestDto update);
    void deleteUser(User user);


}
