package com.bootcampW22.EjercicioGlobal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    private String registration;
    private String color;
    private int year;
    private String max_speed;
    private int passengers;
    private String fuel_type;
    private String transmission;
    private double height;
    private double width;
    private double weight;

    @JsonIgnore
    public double getMaxSpeedAsDouble() {
        try {
            return Double.parseDouble(max_speed);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
