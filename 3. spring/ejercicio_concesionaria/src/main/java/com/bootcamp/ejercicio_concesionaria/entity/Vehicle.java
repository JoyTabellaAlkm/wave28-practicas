package com.bootcamp.ejercicio_concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class Vehicle {
    private static Long counter = 0L;

    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
    private List<Service> services;

    public Vehicle() {
        counter++;
        this.id = counter;
    }
}
