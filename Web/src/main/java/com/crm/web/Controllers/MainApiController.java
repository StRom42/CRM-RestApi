package com.crm.web.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class MainApiController {
    @GetMapping
    public RedirectView swaggerUi() {
        return new RedirectView("/swagger-ui.html");
    }

    @GetMapping("health")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> health(){
        return ResponseEntity.ok("Healthy");
    }

    @GetMapping("version")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> version(){
        return ResponseEntity.ok("v1.0.0");
    }


}
