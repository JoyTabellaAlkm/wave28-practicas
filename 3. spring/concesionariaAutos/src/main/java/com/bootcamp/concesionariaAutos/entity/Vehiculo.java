package com.bootcamp.concesionariaAutos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    int id;
    String brand;
    String model;
    LocalDate manufacturingDate;
    double numberofKilometers;
    int doors;
    double price;
    double currency;
    List<Servicio> servicios;
    int countOfOwners;
}
