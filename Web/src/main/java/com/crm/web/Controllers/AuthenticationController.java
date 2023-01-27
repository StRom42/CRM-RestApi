package com.crm.web.Controllers;

import com.crm.application.Dto.AuthRefreshRequestDto;
import com.crm.application.Dto.AuthRequestDto;
import com.crm.application.Dto.AuthResponseDto;
import com.crm.application.Dto.SignUpRequestDto;
import com.crm.application.Services.AuthService;
import com.crm.application.Utils.Exceptions.Auth.AuthToken.InvalidAuthTokenException;
import com.crm.application.Utils.Exceptions.Auth.Duplicate.UserDuplicateException;
import com.crm.application.Utils.Exceptions.Auth.NotFound.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthService authService;


    @PostMapping(
            path = "signup",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> signUp(
            @RequestBody SignUpRequestDto signUpRequestDto
    ) throws UserDuplicateException {
        authService.signUp(signUpRequestDto);
        return ResponseEntity.ok("Successfully signed up");
    }

    @PostMapping(
            path = "signin",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AuthResponseDto> signIn(
            @RequestBody AuthRequestDto authRequestDto
    ) throws UserNotFoundException {
        AuthResponseDto response = authService.signIn(authRequestDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping(
            path = "accessToken",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AuthResponseDto> getAccessToken(
            @RequestBody AuthRefreshRequestDto authRefreshRequestDto
            ) throws InvalidAuthTokenException {
        AuthResponseDto response = authService.getAccessToken(authRefreshRequestDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping(
            path = "refreshTokens",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AuthResponseDto> refreshTokens(
            @RequestBody AuthRefreshRequestDto authRefreshRequestDto
    ) throws InvalidAuthTokenException {
        AuthResponseDto response = authService.refresh(authRefreshRequestDto);
        return ResponseEntity.ok(response);
    }
}
