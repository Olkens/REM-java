package com.rem.realEstate;

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
    public ResponseEntity<List<RealEstate>> getAllRealEstates() {
        List<RealEstate> realEstates = realEstateService.getAllRealEstates();
        return ResponseEntity.ok(realEstates);
    }

    @PostMapping("/")
    public ResponseEntity<RealEstate> saveRealEstate(@RequestBody RealEstateDTO dto) {
        RealEstate realEstate = realEstateService.saveRealEstate(dto);
        return ResponseEntity.ok(realEstate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RealEstate> getRealEstateById(@PathVariable long id) {
        RealEstate realEstate = realEstateService.getRealEstate(id);
        return ResponseEntity.ok(realEstate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RealEstate> updateRealEstate(@PathVariable long id, @RequestBody RealEstateDTO dto) {
        RealEstate realEstate = realEstateService.updateRealEstate(id, dto);
        return ResponseEntity.ok(realEstate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRealEstate(@PathVariable long id) {
        realEstateService.deleteRealEstate(id);
        return ResponseEntity.ok("Real estate deleted successfully!");
    }
}
