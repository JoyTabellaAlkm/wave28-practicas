package com.dario.dominguez.practicaconcesionaria.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class Vehicle implements Serializable {
    private long id;
    private String brand;
    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd")  // Especifica solo el formato de fecha
    private Date manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;
}
