package org.bootcampmeli.ejercicioconcesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bootcampmeli.ejercicioconcesionaria.entity.Servicio;


import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class Vehiculo {
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
    private List<Servicio> services;
}