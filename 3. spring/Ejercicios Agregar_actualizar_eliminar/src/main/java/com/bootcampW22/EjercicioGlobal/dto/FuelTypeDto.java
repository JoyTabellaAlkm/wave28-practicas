package com.bootcampW22.EjercicioGlobal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuelTypeDto {
    @JsonProperty("fuel_type")
    String fuelType;

}
