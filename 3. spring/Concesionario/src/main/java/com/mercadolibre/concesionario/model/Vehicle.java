package com.mercadolibre.concesionario.model;


import lombok.Data;

@Data
public class Vehicle {
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;


}
