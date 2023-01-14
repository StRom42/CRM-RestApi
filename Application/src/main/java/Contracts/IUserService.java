package Contracts;

import Models.Users.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;
import java.util.function.Predicate;

public interface IUserService extends UserDetailsService {
    boolean addUser(User user);
    void updateUser(User user);

}
