package com.rem.auth;

import com.rem.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        LoginResponseDTO loginResponseDTO = authService.login(body.getUsername(), body.getPassword());
        return new ResponseEntity<>(loginResponseDTO, HttpStatus.OK).getBody();
    }
}
