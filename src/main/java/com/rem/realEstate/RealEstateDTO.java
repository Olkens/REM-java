package com.rem.realEstate;

import com.rem.address.AddressDTO;

public record RealEstateDTO(String name, Double cubicMeters, String owner, Double price, AddressDTO address){}
