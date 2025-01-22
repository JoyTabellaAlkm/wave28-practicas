package com.example.Concesionario.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class VehicleIdDto {

    private Integer id;
    private String brand;
    private String model;
    private LocalDate date;
    private Long mileage;
    private Integer doors;
    private Long price;
    private List<ServiceVehiclesIdDto> services;
}
