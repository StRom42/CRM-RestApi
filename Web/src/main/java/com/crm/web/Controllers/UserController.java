package com.crm.web.Controllers;

import com.crm.application.Contracts.IUserService;
import com.crm.application.Dto.SignUpRequestDto;
import com.crm.application.Dto.UpdateUserRequestDto;
import com.crm.application.Utils.Exceptions.Auth.Duplicate.UserDuplicateException;
import com.crm.data.Models.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public IUserService userService;

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> updateUser(
            @AuthenticationPrincipal User user,
            @RequestBody UpdateUserRequestDto updateDto
            ) {
        userService.updateUser(user, updateDto);
            return ResponseEntity.ok("\"Successfully updated\"");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(
            @AuthenticationPrincipal User user
    ) {
        userService.deleteUser(user);
        return ResponseEntity.ok("\"Successfully deleted\"");
    }

}
