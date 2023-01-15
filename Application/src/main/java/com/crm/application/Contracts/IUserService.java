package com.crm.application.Contracts;

import com.crm.data.Models.Users.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface IUserService extends UserDetailsService {
    boolean addUser(User user);
    void updateUser(User user);

}
