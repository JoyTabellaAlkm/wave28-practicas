package com.bootcamp.concesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Vehiculo {
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private double kilometers;
    private int doors;
    private double price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;
}
