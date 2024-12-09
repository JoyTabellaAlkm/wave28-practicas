package com.mercadolibre.concesionariodeautos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Auto {
    private Integer id;
    private String brand;
    private String model;
    @JsonProperty("manufacturing_date")
    private LocalDate manufacturingDate;
    @JsonProperty("number_of_kilometers")
    private Double numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    @JsonProperty("count_of_owners")
    private Integer countOfOwners;
}
