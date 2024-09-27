package com.rem.person;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class PersonController {

    @GetMapping("/")
    public String helloPerson(){
        return "Hello World";
    }

}