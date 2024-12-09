package com.concesionariaapi.concesionaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    @JsonProperty()
    private String brand;
    @JsonProperty()
    private String model;
    @JsonProperty("manufacturing_date")
    private String manufacturingDate;
    @JsonProperty("number_of_kilometers")
    private String numberOfKilometers;
    @JsonProperty()
    private String doors;
    @JsonProperty()
    private Integer price;
    @JsonProperty()
    private String currency;
    @JsonProperty("count_of_owners")
    private String countOfOwners;
    @JsonProperty()
    private Integer Id;
    @JsonProperty()
    private List<Servicio> services;
}

