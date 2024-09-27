package com.rem.auth;

import com.rem.person.Person;
import com.rem.role.Role;
import com.rem.repository.PersonRepository;
import com.rem.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public Person registerPerson(String username, String password) {

        String hashedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return personRepository.save(new Person(username, hashedPassword, authorities));
    }

    public LoginResponseDTO login(String username, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password)
            );

            String token = tokenService.generateJwt(authentication);

            return new LoginResponseDTO(personRepository.findByUsername(username).get(), token);
        } catch (Exception e) {
            return new LoginResponseDTO(null, "");
        }
    }
}
