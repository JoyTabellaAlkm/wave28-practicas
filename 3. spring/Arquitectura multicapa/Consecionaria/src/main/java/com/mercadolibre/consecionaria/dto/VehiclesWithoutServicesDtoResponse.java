package com.mercadolibre.consecionaria.dto;

import com.mercadolibre.consecionaria.entity.Services;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiclesWithoutServicesDtoResponse {
    String brand;
    String model;
    String manufacturingDte;
    int numberOfKilometers;
    String doors;
    String price;
    String currency;
    String countOfOwners;
}
