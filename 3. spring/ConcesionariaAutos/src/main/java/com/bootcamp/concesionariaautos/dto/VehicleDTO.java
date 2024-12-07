package com.bootcamp.concesionariaautos.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private String brand;
    private String model;
    @JsonProperty("manufacturing_date")
    @JsonAlias("manufacturingDate")
    private String manufacturingDate;
    @JsonProperty("number_of_kilometers")
    @JsonAlias("km")
    private String km;
    private String doors;
    private String price;
    private String currency;
    private List<ServiceDTO> services;
    @JsonProperty("count_of_owners")
    @JsonAlias("countOfOwners")
    private String countOfOwners;
}
