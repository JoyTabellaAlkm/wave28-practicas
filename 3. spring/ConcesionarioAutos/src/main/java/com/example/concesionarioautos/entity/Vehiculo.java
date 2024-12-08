package com.example.concesionarioautos.entity;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Vehiculo {
    String brand;
    String model;
    Date manuFacturingDate;
    Integer doors;
    String price;
    String currency;
    List<Servicios> services;
    Integer countOfOwners;
}
