package com.dario.dominguez.practicaconcesionaria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class VehicleDto {
    private long id;
    private String brand;
    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd")  // Especifica solo el formato de fecha
    private Date manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<ServiceDto> services;
    private String countOfOwners;
}
