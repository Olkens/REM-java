package com.rem.models;


import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

    final static String ROLE_ADMIN = "ROLE_ADMIN";
    final static String ROLE_USER = "ROLE_USER";
    final static String ROLE_COMPANY_ADMIN = "ROLE_COMPANY_ADMIN";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer roleId;

    private String authority;

    public Role() {
        super();
    }

    public Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getId() {
        return roleId;
    }
}
