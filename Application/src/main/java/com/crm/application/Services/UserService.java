package com.crm.application.Services;

import com.crm.application.Contracts.IUserService;
import com.crm.application.Dto.SignUpRequestDto;
import com.crm.application.Dto.UpdateUserRequestDto;
import com.crm.application.Utils.Exceptions.Auth.Duplicate.UserDuplicateException;
import com.crm.data.Models.Users.Roles.ObserverRole;
import com.crm.data.Models.Users.User;
import com.crm.data.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Collections;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getByLogin(username);
    }

    public void addUser(@Valid SignUpRequestDto dto) throws UserDuplicateException {
        if (userRepository.findByLogin(dto.login) != null) {
            throw new UserDuplicateException(dto.login);
        }

        User user = new User();

        user.setName(dto.name);
        user.setLogin(dto.login);
        user.setPassword(passwordEncoder.encode(dto.password));
        user.setRoles(Collections.singleton(new ObserverRole()));
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user, @Valid UpdateUserRequestDto update) {
        User updatedUser = new User();

        updatedUser.setName(update.name);
        updatedUser.setLogin(update.login);
        updatedUser.setPassword(update.password);
        updatedUser.setRoles(user.getRoles());

        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteByLogin(user.getLogin());
    }

    protected User getByLogin(String login) {
        User user = userRepository.findByLogin(login);

        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
