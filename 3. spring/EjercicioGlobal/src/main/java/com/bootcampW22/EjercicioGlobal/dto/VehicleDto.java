package com.bootcampW22.EjercicioGlobal.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto {
    private Long id;
    @NotBlank(message = "Se debe especificar la marca del vehículo")
    @Size(min = 3, max = 50, message = "La marca debe de tener entre 3 y 50 caracteres")
    private String brand;
    @NotBlank(message = "Se debe especificar el modelo del vehículo")
    @Size(min = 3, max = 50, message = "El modelo debe de tener entre 3 y 50 caracteres")
    private String model;
    @NotBlank(message = "Se debe especificar la matrícula del vehículo")
    @Size(min = 2, max = 50, message = "la matrícula debe de tener entre 2 y 10 caracteres")
    private String registration;
    @NotBlank(message = "Se debe especificar el color del vehículo")
    @Size(min = 3, max = 50, message = "El color  debe de tener entre 3 y 20 caracteres")
    private String color;
    @NotNull(message = "Se debe especificar el año de fabricación del vehículo")
    @Min(value = 1990, message = "El año de fabricación no puede ser anterior a 1990")
    @Max(value = 2025, message = "El año de fabricación no puede ser superior a 2025")
    private int year;
    @NotBlank(message = "Se debe especificar le velocidad máxima del vehículo")
    @Pattern(regexp = "^(?!0$)([1-9][0-9]{0,2}|500)$", message = "La velocidad máxima debe ser un número entero entre 1 y 500")
    private String max_speed;
    @NotNull(message = "Se debe especificar la cantidad de pasajeros del vehículo")
    @Min(value = 1, message = "La cantidad de pasajeros no puede ser menor a 1")
    @Max(value = 50, message = "La cantidad de pasajeros no puede ser superior a 50")
    private int passengers;
    @NotBlank(message = "Se debe especificar el tipo de combustible del vehículo")
    @Size(min = 3, max = 50, message = "El tipo de combustible debe de tener entre 3 y 50 caracteres")
    private String fuel_type;
    @NotBlank(message = "Se debe especificar el tipo de transmisión del vehículo")
    @Size(min = 3, max = 50, message = "El tipo de transmisión debe de tener entre 3 y 50 caracteres")
    private String transmission;
    @NotNull(message = "Se debe especificar la altura del vehículo")
    @Min(value = 1, message = "La altura no puede ser menor a 1")
    @Max(value = 200, message = "La altura no puede ser superior a 8")
    private double height;
    @NotNull(message = "Se debe especificar la anchura del vehículo")
    @Min(value = 1, message = "La anchura no puede ser menor a 1")
    @Max(value = 200, message = "La anchura no puede ser superior a 8")
    private double width;
    @NotNull(message = "Se debe especificar el peso del vehículo")
    @Min(value = 1, message = "El peso no puede ser menor a 1")
    @Max(value = 5000, message = "El peso no puede ser superior a 8")
    private double weight;
}
