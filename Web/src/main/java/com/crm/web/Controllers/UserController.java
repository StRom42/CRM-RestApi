package com.crm.web.Controllers;

import com.crm.application.Contracts.IUserService;
import com.crm.application.Dto.SignUpDto;
import com.crm.application.Exceptions.Duplicate.UserDuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public IUserService userService;

    @PostMapping(
            path = "signup",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> signUp(
            @RequestBody @Valid SignUpDto signUpDto
    ) throws UserDuplicateException {
        if (userService.addUser(signUpDto)) {
            return ResponseEntity.ok("Success");
        }
        else {
            return ResponseEntity.badRequest().build();
        }

    }

}
