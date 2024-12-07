package com.ar.mercadolibre.cardealership.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Data
public class Vehicle {

    private static AtomicLong autoIncrementalId = new AtomicLong(1);

    private Long id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Maintenance> services;
    private String countOfOwners;

    public Vehicle() {
        this.id = autoIncrementalId.getAndIncrement();
    }

    public Vehicle(String brand, String model, String manufacturingDate, String numberOfKilometers, String doors, String price, String currency, List<Maintenance> services, String countOfOwners) {

        this.id = autoIncrementalId.getAndIncrement();
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
