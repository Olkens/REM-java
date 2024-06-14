package com.rem.dto.realEstate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RealEstateDTO {
    public String name;
    public Double cubicMeters;
    public String owner;
    public Double price;
}
