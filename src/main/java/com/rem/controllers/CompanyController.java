package com.rem.controllers;

import com.rem.services.CompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/companies")
@RestController
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/assign-person")
    public void assignPersonToCompany(@RequestBody Map<String, String> body) {
        companyService.assignPersonToCompany(body.get("email"));
    }
}
