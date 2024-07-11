package com.rem.controllers;

import com.rem.dto.realEstate.RealEstateDTO;
import com.rem.models.RealEstate;
import com.rem.repository.RealEstateRepository;
import com.rem.services.RealEstateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/real-estates")
public class RealEstateController {

    private final RealEstateService realEstateService;

    public RealEstateController(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    @GetMapping("/")
    public List<RealEstate> getAllRealEstates() {
        return realEstateService.getAllRealEstates();
    }

    @Secured("ROLE_COMPANY_USER")
    @PostMapping("/")
    public RealEstate saveRealEstate(@RequestBody RealEstateDTO dto) {
        return realEstateService.saveRealEstate(dto);
    }

    @GetMapping("/{id}")
    public RealEstate getRealEstateById(@PathVariable long id) {
        return realEstateService.getRealEstate(id);
    }

    @PutMapping("/{id}")
    public RealEstate updateRealEstate(@PathVariable long id, @RequestBody RealEstateDTO dto) {
        return realEstateService.updateRealEstate(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteRealEstate(@PathVariable long id) {
        realEstateService.deleteRealEstate(id);
        return new ResponseEntity<>("Real estate deleted successfully!",HttpStatus.OK).getBody();
    }
}
