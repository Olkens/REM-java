package com.rem.factories;

import com.rem.models.Address;
import com.rem.repository.AddressRepository;
import org.springframework.stereotype.Component;
import com.rem.dto.address.AddressDTO;

@Component
public class AddressFactory {

    private final AddressRepository addressRepository;

    public AddressFactory(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddress(AddressDTO dto) {
        Address address = new Address();
        address.setCity(dto.city);
        address.setPostal(dto.postal);
        address.setStreet(dto.street);
        addressRepository.save(address);
        return address;
    }
}
