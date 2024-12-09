package com.mercadolibre.concesionariodeautos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutoResponseDTO {
    private String brand;
    private String model;
    @JsonProperty("manufacturing_date")
    private String manufacturingDate;
    @JsonProperty("number_of_kilometers")
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    @JsonProperty("count_of_owners")
    private String countOfOwners;
}

