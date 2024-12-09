package org.bootcampmeli.ejercicioconcesionaria.dto;



import lombok.AllArgsConstructor;
import lombok.Data;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class VehiculoDTO {
    private Long id; // Asigne esto al crear el objeto
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
    private List<ServicioDTO> services;
}