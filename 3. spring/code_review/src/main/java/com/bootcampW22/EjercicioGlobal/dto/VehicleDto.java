package com.bootcampW22.EjercicioGlobal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @JsonProperty("max_speed")
    private String maxSpeed;

    private int passengers;

    @JsonProperty("fuel_type")
    private String fuelType;

    private String transmission;

    private double height;

    private double width;

    private double weight;
}
