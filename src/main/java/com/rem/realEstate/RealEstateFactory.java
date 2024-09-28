package com.rem.realEstate;

import org.springframework.stereotype.Component;

@Component
public class RealEstateFactory {
    public RealEstate crateRealEstate(RealEstateDTO dto) {
        RealEstate r = new RealEstate();
        r.setName(dto.name());
        r.setCubicMeters(dto.cubicMeters());
        r.setOwner(dto.owner());
        r.setPrice(dto.price());
        return r;
    }
}
