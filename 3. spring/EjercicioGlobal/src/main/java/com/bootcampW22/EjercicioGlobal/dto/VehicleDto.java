package com.bootcampW22.EjercicioGlobal.dto;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto {
    private Long id;
    @NotBlank(message = "Se debe especificar la marca del vehículo")
    @Size(min = 3, max = 50, message = "El nombre de la marca debe de tener entre 3 y 50 caracteres")
    private String brand;
    private String model;
    private String registration;
    private String color;
    @Digits(integer = 4, fraction = 0, message = "Se debe ingresar un año válido, debe ser entero y tener 4 dígitos")
    @Positive(message = "Se debe especificar el año como un número entero positivo")
    private int year;
    private String max_speed;
    private int passengers;
    @NotBlank(message = "Se debe especificar el tipo de combustible a actualizar")
    @Size(min = 3, max = 50, message = "El tipo de combustible debe de tener entre 3 y 50 caracteres")
    private String fuel_type;
    private String transmission;
    private double height;
    private double width;
    private double weight;
}
