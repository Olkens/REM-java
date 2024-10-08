package com.rem.services;

import com.rem.models.Person;
import com.rem.models.Role;
import com.rem.repository.CompanyRepository;
import com.rem.repository.PersonRepository;
import com.rem.repository.RoleRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final PersonRepository personRepository;
    private final PersonService personService;
    private final RoleRepository roleRepository;

    public CompanyService(CompanyRepository companyRepository, PersonRepository personRepository, PersonService personService, RoleRepository roleRepository) {
        this.companyRepository = companyRepository;
        this.personRepository = personRepository;
        this.personService = personService;
        this.roleRepository = roleRepository;
    }

    public void assignPersonToCompany(String email){
        Person person = personRepository.findByUsername(email).orElse(null);
        Person loggedPerson = personService.findCurrelntlyLoggedInPerson();
        if(person != null){
            person.setCompany(loggedPerson.getCompany());
            Role companyUserRole = roleRepository.findByAuthority("ROLE_COMPANY_USER").orElseThrow();
            person.addNewRole(companyUserRole);
            personRepository.save(person);
        }
    }
}
