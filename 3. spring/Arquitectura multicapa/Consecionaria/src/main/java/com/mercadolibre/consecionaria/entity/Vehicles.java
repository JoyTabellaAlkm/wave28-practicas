package com.mercadolibre.consecionaria.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Vehicles {
    String brand;
    String model;
    String manufacturingDte;
    int numberOfKilometers;
    String doors;
    String price;
    String currency;
    List<Services> services;
    String countOfOwners;
}
