package com.concesionariaapi.concesionaria.dto;

import com.concesionariaapi.concesionaria.model.Servicio;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private Integer price;
    private String currency;
    private String countOfOwners;
    private Integer Id;
    private List<Servicio> services;
}
