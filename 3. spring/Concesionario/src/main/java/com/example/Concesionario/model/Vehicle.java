package com.example.Concesionario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private Integer id;
    private String brand;
    private String model;
    private LocalDate entryDate;
    private Long mileage;
    private Integer doors;
    private Long price;
    private List<ServiceModel> serviceModels;

}
