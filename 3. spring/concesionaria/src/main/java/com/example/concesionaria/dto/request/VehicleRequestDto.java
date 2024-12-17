package com.example.concesionaria.dto.request;

import com.example.concesionaria.model.Service;
import lombok.Data;

import java.util.List;

@Data
public class VehicleRequestDto {

    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> servicios;
    private String countOfOwners;
}
