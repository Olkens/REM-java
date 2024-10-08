package com.rem.services;


import com.rem.models.Person;
import com.rem.models.Role;
import com.rem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Service
public class PersonService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }

    public Person findCurrelntlyLoggedInPerson(){
        String loggedPersonUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        return personRepository.findByUsername(loggedPersonUsername).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
