package com.bootcamp.concesionariaAutos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoResponseDTO {
    String brand;
    String model;
    LocalDate manufacturingDate;
    double numberofKilometers;
    int doors;
    double price;
    double currency;
    List<ServicioDTO> servicios;
    int countOfOwners;
}
