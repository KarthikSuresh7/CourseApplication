package com.io.swagger.SwaggerDocumentation.controller;

import com.io.swagger.SwaggerDocumentation.Service.AuthenticationService;
import com.io.swagger.SwaggerDocumentation.form.AunthenticationResponse;
import com.io.swagger.SwaggerDocumentation.form.AuthenticationResponse;
import com.io.swagger.SwaggerDocumentation.form.LoginForm;
import com.io.swagger.SwaggerDocumentation.form.RegisterForm;
import com.io.swagger.SwaggerDocumentation.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {


    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterForm request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginForm request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
