package com.example.concecionaria.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private String brand;
    private String model;
    private LocalDate manufactoringDate;
    private int numberOfKilometers;
    private int doors;
    private int price;
    private String currency;
    private List<Services> services;
    private int countOfOwners;

}
