package com.bootcampW22.EjercicioGlobal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto {
    @NonNull
    private Long id;
    @NonNull
    private String brand;
    @NonNull
    private String model;
    @NonNull
    private String registration;
    @NonNull
    private String color;
    private int year;
    @NonNull
    private String max_speed;
    private int passengers;
    @NonNull
    private String fuel_type;
    @NonNull
    private String transmission;
    private double height;
    private double width;
    private double weight;
}
