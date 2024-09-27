package com.rem.realEstate;

import com.rem.address.AddressFactory;
import com.rem.address.Address;
import com.rem.repository.RealEstateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<RealEstate> getAllRealEstates() {
        return realEstateRepository.findAll();
    }

    public RealEstate saveRealEstate(RealEstateDTO realEstateDTO) {
        RealEstate re = realEstateFactory.crateRealEstate(realEstateDTO);
        Address address = addressFactory.createAddress(realEstateDTO.address);
        re.setAddress(address);
        realEstateRepository.save(re);
        return re;
    }

    public RealEstate getRealEstate(Long id) {
        return realEstateRepository.findById(id).orElseThrow();
    }

    public RealEstate updateRealEstate(Long id, RealEstateDTO realEstateDTO) {
        RealEstate realEstate = realEstateRepository.findById(id).orElseThrow();
        realEstate.updateProperties(realEstateDTO);
        realEstateRepository.save(realEstate);
        return realEstate;
    }

    public void deleteRealEstate(Long id) {
        realEstateRepository.deleteById(id);
    }
}
