package com.rem.controllers;

import com.rem.dto.realEstate.RealEstateDTO;
import com.rem.models.RealEstate;
import com.rem.repository.RealEstateRepository;
import com.rem.services.RealEstateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/real-states")
public class RealEstateController {

    private final RealEstateService realEstateService;
    private final RealEstateRepository realEstateRepository;

    public RealEstateController(RealEstateRepository realEstateRepository, RealEstateService realEstateService) {
        this.realEstateRepository = realEstateRepository;
        this.realEstateService = realEstateService;
    }

    @GetMapping("/")
    public List<RealEstate> getAllRealEstates() {
        return realEstateRepository.findAll();
    }

    @PostMapping("/")
    public RealEstate save(@RequestBody RealEstateDTO dto) {
        return realEstateService.saveRealEstate(dto);
    }

    @GetMapping("/{id}")
    public RealEstate getRealEstateById(@PathVariable long id) {
        return realEstateRepository.findById(id).orElseThrow();
    }


}
