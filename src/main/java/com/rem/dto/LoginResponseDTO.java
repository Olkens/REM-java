package com.rem.dto;

import com.rem.models.Person;

public class LoginResponseDTO {
    private Person person;
    private String jwt;

    public LoginResponseDTO(Person person, String jwt) {
        this.jwt = jwt;
        this.person = person;
    }

    public LoginResponseDTO() {
        super();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
