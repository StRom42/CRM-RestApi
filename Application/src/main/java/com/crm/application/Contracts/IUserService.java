package com.crm.application.Contracts;

import com.crm.application.Dto.SignUpDto;
import com.crm.application.Dto.UpdateUserDto;
import com.crm.application.Exceptions.Duplicate.UserDuplicateException;
import com.crm.data.Models.Users.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface IUserService extends UserDetailsService {
    boolean addUser(SignUpDto signUpDto) throws UserDuplicateException;
    boolean updateUser(User user, UpdateUserDto update);
    boolean deleteUser(User user);


}
