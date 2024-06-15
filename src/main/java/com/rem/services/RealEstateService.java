package com.rem.services;

import com.rem.dto.realEstate.RealEstateDTO;
import com.rem.factories.AddressFactory;
import com.rem.factories.RealEstateFactory;
import com.rem.models.Address;
import com.rem.models.RealEstate;
import com.rem.repository.RealEstateRepository;
import org.springframework.stereotype.Service;

@Service
public class RealEstateService {

    private final RealEstateRepository realEstateRepository;
    private final RealEstateFactory realEstateFactory;
    private final AddressFactory addressFactory;

    public RealEstateService(RealEstateRepository realEstateRepository, RealEstateFactory realEstateFactory, AddressFactory addressFactory) {
        this.realEstateRepository = realEstateRepository;
        this.realEstateFactory = realEstateFactory;
        this.addressFactory = addressFactory;
    }

    public RealEstate saveRealEstate(RealEstateDTO realEstateDTO) {
        RealEstate re = realEstateFactory.crateRealEstate(realEstateDTO);
        Address address = addressFactory.createAddress(realEstateDTO.address);
        re.setAddress(address);
        realEstateRepository.save(re);
        return re;
    }
}
