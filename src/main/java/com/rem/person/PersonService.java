package com.rem.person;


import com.rem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class PersonService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final PersonRepository personRepository;

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
