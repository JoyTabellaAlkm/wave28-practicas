package com.ar.mercadolibre.cardealership.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"autoIncrementalId", "services"})
@Data
public class VehicleBasicDTO {

    private Long id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;
}
