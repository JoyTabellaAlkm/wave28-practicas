package com.example.concesionaria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleResponseDTO {

    private String license;
    private String brand;
    private String model;
    private int year;

}
