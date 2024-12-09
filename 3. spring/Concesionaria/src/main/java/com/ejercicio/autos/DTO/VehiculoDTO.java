package com.ejercicio.autos.DTO;

import com.ejercicio.autos.Model.Servicio;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class VehiculoDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<Servicio> services;
    private int countOfOwners;
}
