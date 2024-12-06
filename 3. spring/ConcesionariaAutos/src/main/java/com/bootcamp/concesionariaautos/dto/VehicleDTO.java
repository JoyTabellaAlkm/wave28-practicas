package com.bootcamp.concesionariaautos.dto;

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
    private String manufacturingDate;
    @JsonProperty("number_of_kilometers")
    private String km;
    private String doors;
    private String price;
    private String currency;
    private List<ServiceDTO> services;
    @JsonProperty("count_of_owners")
    private String countOfOwners;
}
