package com.example.concesionarioautos.dto;

import com.example.concesionarioautos.entity.Servicios;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class VehiculoDTO {
    String brand;
    String model;
    Date manuFacturingDate;
    Integer doors;
    String price;
    String currency;
    List<Servicios> services;
    Integer countOfOwners;
}
