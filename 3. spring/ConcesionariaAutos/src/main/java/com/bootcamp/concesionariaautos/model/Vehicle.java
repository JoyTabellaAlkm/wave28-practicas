package com.bootcamp.concesionariaautos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    @JsonProperty("manufacturing_date")
    private LocalDate manufacturingDate;
    @JsonProperty("number_of_kilometers")
    private Double km;
    private Integer doors;
    private Double price;
    private String currency;
    @JsonProperty("count_of_owners")
    private Integer countOfOwners;
}
