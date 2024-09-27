package com.rem;

import com.rem.person.Person;
import com.rem.role.Role;
import com.rem.repository.PersonRepository;
import com.rem.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class RealEstateMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstateMarketApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, PersonRepository personRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;

			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			Person admin = new Person("admin", passwordEncoder.encode("password"), roles);

			personRepository.save(admin);
		};
	}

}
