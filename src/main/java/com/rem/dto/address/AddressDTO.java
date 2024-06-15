package com.rem.dto.address;

public class AddressDTO {
    public String city;
    public String postal;
    public String street;

    public AddressDTO(String city, String postal, String street) {
        this.city = city;
        this.postal = postal;
        this.street = street;
    }

    public AddressDTO() {}
}
