package com.crm.application.Services;

import com.crm.application.Contracts.IUserService;
import com.crm.application.Dto.SignUpDto;
import com.crm.application.Dto.UpdateUserDto;
import com.crm.application.Exceptions.Duplicate.UserDuplicateException;
import com.crm.data.Models.Users.Roles.ObserverRole;
import com.crm.data.Models.Users.User;
import com.crm.data.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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

    public boolean addUser(SignUpDto dto) throws UserDuplicateException {
        if (userRepository.findByLogin(dto.login) != null) {
            throw new UserDuplicateException(dto.login);
        }

        User user = new User();

        user.setName(dto.name);
        user.setLogin(dto.login);
        user.setPassword(passwordEncoder.encode(dto.password));
        user.setRoles(Collections.singleton(new ObserverRole()));
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean updateUser(User user, UpdateUserDto update) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }
}
