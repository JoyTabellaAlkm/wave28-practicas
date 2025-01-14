package com.example.concesionaria.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequestDTO {

    private String license;
    private String brand;
    private String model;
    private int year;
    private String numberOfKilometers;


}
