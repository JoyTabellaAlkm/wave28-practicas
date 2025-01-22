package com.example.Concesionario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceModel {

    private Integer id;
    private LocalDate date;
    private Long mileage;
    private String descriptions;
}
