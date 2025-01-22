package com.example.Concesionario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VehicleAllDto {
    private Integer id;
    private String brand;
    private String model;

    @JsonProperty("entry_date")
    private LocalDate entryDate;
    private Long mileage;
    private Integer doors;
    private Long price;

}
