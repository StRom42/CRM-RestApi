package com.crm.application.Services;

import com.crm.application.Dto.AuthRefreshRequestDto;
import com.crm.application.Dto.AuthRequestDto;
import com.crm.application.Dto.AuthResponseDto;
import com.crm.application.Dto.SignUpRequestDto;
import com.crm.application.Utils.Auth.JwtAuthentication;
import com.crm.application.Utils.Exceptions.Auth.AuthToken.InvalidAuthTokenException;
import com.crm.application.Utils.Exceptions.Auth.Duplicate.UserDuplicateException;
import com.crm.application.Utils.Exceptions.Auth.NotFound.UserNotFoundException;
import com.crm.application.Utils.Auth.JwtProvider;
import com.crm.data.Models.Users.Jwt.RefreshJwt;
import com.crm.data.Models.Users.User;
import com.crm.data.Repositories.IJwtRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private IJwtRepository tokenRepository;

    public void signUp(@Valid SignUpRequestDto dto) throws UserDuplicateException {
        userService.addUser(dto);
    }

    public AuthResponseDto signIn(@Valid AuthRequestDto request) throws UserNotFoundException {
        final User user = userService.getByLogin(request.login);

        if (encoder.matches(request.password, user.getPassword())) {
            AuthResponseDto response = new AuthResponseDto();
            response.accessToken = jwtProvider.generateAccessToken(user);
            response.refreshToken = jwtProvider.generateRefreshToken(user);

            tokenRepository.save(new RefreshJwt(response.refreshToken, user.getLogin()));

            return response;
        }
        else {
            throw new UserNotFoundException(user.getLogin());
        }
    }

    public AuthResponseDto getAccessToken(AuthRefreshRequestDto authRefreshRequestDto) throws InvalidAuthTokenException {
        String refreshToken = authRefreshRequestDto.refreshToken;
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final Optional<String> saveRefreshToken = tokenRepository.findByLogin(login);
            if (saveRefreshToken.isPresent() && saveRefreshToken.get().equals(refreshToken)) {
                final User user = userService.getByLogin(login);
                final String accessToken = jwtProvider.generateAccessToken(user);
                return new AuthResponseDto(accessToken, null);
            }
        }
        throw InvalidAuthTokenException.invalid();
    }

    public AuthResponseDto refresh(AuthRefreshRequestDto authRefreshRequestDto) throws InvalidAuthTokenException {
        String refreshToken = authRefreshRequestDto.refreshToken;
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final Optional<String> saveRefreshToken = tokenRepository.findByLogin(login);
            if (saveRefreshToken.isPresent() && saveRefreshToken.get().equals(refreshToken)) {
                final User user = userService.getByLogin(login);
                final String accessToken = jwtProvider.generateAccessToken(user);
                final String newRefreshToken = jwtProvider.generateRefreshToken(user);

                tokenRepository.save(new RefreshJwt(newRefreshToken, user.getLogin()));
                return new AuthResponseDto(accessToken, newRefreshToken);
            }
        }
        throw InvalidAuthTokenException.invalid();
    }

    public JwtAuthentication getAuthentication() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}
