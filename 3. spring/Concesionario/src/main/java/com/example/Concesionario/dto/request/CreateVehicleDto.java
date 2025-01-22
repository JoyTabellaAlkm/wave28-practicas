package com.example.Concesionario.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CreateVehicleDto {

    private String brand;
    private String model;
    private LocalDate entryDate;
    private Long mileage;
    private Integer doors;
    private Long price;
    private List<CreateServiceDto> services;
}
