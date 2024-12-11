package com.mercadoLibre.concesionariaAutos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Auto {
    private static AtomicLong automaticId = new AtomicLong(1);
    private Long id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<ServiceEntity> services;
    private String countOfOwners;

    public Auto(String brand, String model, String manufacturingDate, String numberOfKilometers, String doors, String price, String currency, List<ServiceEntity> services, String countOfOwners) {
        this.id = automaticId.getAndIncrement();
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }
}
