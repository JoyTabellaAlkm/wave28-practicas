package com.mercadolibre.concesionarioautos.dto;

import java.time.LocalDate;

public class CarDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<ServiceDTO> services;
    private int countOfOwnsers;
}
