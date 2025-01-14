package com.mercadolibre.autoinsurance.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequestDto {
    private String patent;
    private String brand;
    private String model;
    @JsonProperty("year_of_manufacture")
    private Short yearOfManufacture;
    @JsonProperty("number_of_wheels")
    private Byte numberOfWheels;
}
