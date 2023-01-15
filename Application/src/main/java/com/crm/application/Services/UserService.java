package com.crm.application.Services;

import com.crm.application.Contracts.IUserService;
import com.crm.data.Models.Users.Roles.ObserverRole;
import com.crm.data.Models.Users.User;
import com.crm.data.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);

        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public boolean addUser(User user){
        if (userRepository.findByLogin(user.getLogin()) != null) {
            return false;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(new ObserverRole()));
        userRepository.save(user);
        return true;
    }

    @Override
    public void updateUser(User user) {

    }
}
