package com.bootcamp.concesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehiculoUsadoDTO {
    private String brand;
    private String model;
    private String manufacturingDate;
    private double kilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;
}
