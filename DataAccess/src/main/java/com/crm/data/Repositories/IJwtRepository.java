package com.crm.data.Repositories;

import com.crm.data.Models.Users.Jwt.RefreshJwt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IJwtRepository extends JpaRepository<RefreshJwt, String> {
    Optional<String> findByLogin(String login);
}
