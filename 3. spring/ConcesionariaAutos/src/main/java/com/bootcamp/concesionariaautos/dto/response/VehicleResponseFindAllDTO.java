package com.bootcamp.concesionariaautos.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponseFindAllDTO {
    private String brand;
    private String model;
    @JsonProperty("manufacturing_date")
    private String manufacturingDate;
    @JsonProperty("number_of_kilometers")
    private String km;
    private String doors;
    private String price;
    private String currency;
    @JsonProperty("count_of_owners")
    private String countOfOwners;
}
