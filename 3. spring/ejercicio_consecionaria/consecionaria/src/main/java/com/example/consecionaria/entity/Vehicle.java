package com.example.consecionaria.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Vehicle {
    private static int counter = 0;
    private int id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;

    public Vehicle(String brand, String model, LocalDate manufacturingDate, int numberOfKilometers, int doors, double price, String currency, List<Service> services, int countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
        this.id = ++counter;
    }
}
