package com.bootcamp.concesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class VehiculoDTO {
    private String brand;
    private String model;
    private String manufacturingDate;
    private double kilometers;
    private int doors;
    private double price;
    private String currency;
    private List<ServiceDTO> services;
    private int countOfOwners;
}
