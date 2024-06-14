package com.rem.services;

import com.rem.dto.realEstate.RealEstateDTO;
import com.rem.factories.RealEstateFactory;
import com.rem.models.RealEstate;
import com.rem.repository.RealEstateRepository;
import org.springframework.stereotype.Service;

@Service
public class RealEstateService {

    private final RealEstateRepository realEstateRepository;
    private final RealEstateFactory realEstateFactory;

    public RealEstateService(RealEstateRepository realEstateRepository, RealEstateFactory realEstateFactory) {
        this.realEstateRepository = realEstateRepository;
        this.realEstateFactory = realEstateFactory;
    }

    public RealEstate saveRealEstate(RealEstateDTO realEstateDTO) {
        RealEstate re = realEstateFactory.crateRealEstate(realEstateDTO);
        realEstateRepository.save(re);
        return re;
    }
}
