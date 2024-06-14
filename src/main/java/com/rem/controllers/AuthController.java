package com.rem.controllers;

import com.rem.dto.LoginResponseDTO;
import com.rem.dto.RegistrationDTO;
import com.rem.models.Person;
import com.rem.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public Person registerPerson(@RequestBody RegistrationDTO body) {
        return authService.registerPerson(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody RegistrationDTO body) {
        return authService.login(body.getUsername(), body.getPassword());
    }
}
