package com.example.Concesionario.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateServiceDto {
    private LocalDate date;
    private Long mileage;
    private String descriptions;
}
