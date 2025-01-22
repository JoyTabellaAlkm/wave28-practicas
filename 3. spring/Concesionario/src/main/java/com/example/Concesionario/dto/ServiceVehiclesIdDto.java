package com.example.Concesionario.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ServiceVehiclesIdDto {
    private Integer id;
    private LocalDate date;
    private Long mileage;
    private String descriptions;
}
