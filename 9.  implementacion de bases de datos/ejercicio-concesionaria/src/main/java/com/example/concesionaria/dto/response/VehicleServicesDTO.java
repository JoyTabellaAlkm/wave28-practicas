package com.example.concesionaria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleServicesDTO {

    private String license;
    private String brand;
    private String model;
    private int year;
    private List<ServiceDTO> services;

}
