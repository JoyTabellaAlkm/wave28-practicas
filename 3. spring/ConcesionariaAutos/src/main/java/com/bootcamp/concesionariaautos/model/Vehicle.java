package com.bootcamp.concesionariaautos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Double km;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
}
