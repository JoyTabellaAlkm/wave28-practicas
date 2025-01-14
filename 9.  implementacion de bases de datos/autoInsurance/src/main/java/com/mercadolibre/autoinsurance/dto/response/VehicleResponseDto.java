package com.mercadolibre.autoinsurance.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "patent", "brand", "model", "yearOfManufacture", "numberOfWheels", "accidents"})
public class VehicleResponseDto {
    private Long id;
    private String patent;
    private String brand;
    private String model;
    @JsonProperty("year_of_manufacture")
    private Short yearOfManufacture;
    @JsonProperty("number_of_wheels")
    private Byte numberOfWheels;
    private List<AccidentResponseDto> accidents;
}
