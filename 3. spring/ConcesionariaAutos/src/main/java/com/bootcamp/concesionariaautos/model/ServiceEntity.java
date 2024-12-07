package com.bootcamp.concesionariaautos.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntity {
    private Long id;
    private Long vehicleID;
    private LocalDate date;
    @JsonAlias("kilometers")
    private Double km;
    private String description;
}
