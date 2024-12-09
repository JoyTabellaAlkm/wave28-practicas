package com.bootcamp.ejercicio_concesionaria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleNoServiceDto implements Serializable {
    private String brand;
    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
}
