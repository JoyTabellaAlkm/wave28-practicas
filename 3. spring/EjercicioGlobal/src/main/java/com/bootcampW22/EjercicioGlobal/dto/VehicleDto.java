package com.bootcampW22.EjercicioGlobal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto {
    private Long id;
    private String brand;
    private String model;
    private String registration;
    private String color;
    private int year;
    private int max_speed;
    private int passengers;
    private String fuel_type;
    private String transmission;
    private double height;
    private double width;
    private double weight;
}
