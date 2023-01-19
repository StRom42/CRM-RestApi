package com.crm.web.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MainApiController {
    @GetMapping("health")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> health(){
        return new ResponseEntity<>("Ok", HttpStatus.ACCEPTED);
    }


}
