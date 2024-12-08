package com.mercadolibre.consecionaria.dto;
import com.mercadolibre.consecionaria.entity.Services;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiclesDtoResponse {
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
