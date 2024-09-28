package com.rem.realEstate;

import com.rem.address.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long realEstateId;
    private String name;
    private Double cubicMeters;
    private String owner;
    private Double price;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


    public RealEstate(Long realEstateId, String name, Double cubicMeters, String owner, Double price, Address address) {
        this.realEstateId = realEstateId;
        this.name = name;
        this.cubicMeters = cubicMeters;
        this.owner = owner;
        this.price = price;
        this.address = address;
    }

    public RealEstate() {
    }

    public Long getRealEstateId() {
        return realEstateId;
    }

    public void setRealEstateId(Long realEstateId) {
        this.realEstateId = realEstateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCubicMeters() {
        return cubicMeters;
    }

    public void setCubicMeters(Double cubicMeters) {
        this.cubicMeters = cubicMeters;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void updateProperties(RealEstateDTO realEstateDTO) {
        this.setName(realEstateDTO.name());
        this.setCubicMeters(realEstateDTO.cubicMeters());
        this.setPrice(realEstateDTO.price());
        this.setName(realEstateDTO.name());
    }
}
