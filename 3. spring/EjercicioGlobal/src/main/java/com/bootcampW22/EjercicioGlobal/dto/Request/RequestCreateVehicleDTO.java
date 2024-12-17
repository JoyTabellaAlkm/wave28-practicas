package com.bootcampW22.EjercicioGlobal.dto.Request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateVehicleDTO {

    @NotNull
    private Long id;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private String registration;

    @NotNull
    private String color;

    @NotNull
    private Integer year;

    @NotNull
    private Double max_speed;

    @NotNull
    private Integer passengers;

    @NotNull
    private String fuel_type;

    @NotNull
    private String transmission;

    @NotNull
    private Double height;

    @NotNull
    private Double width;

    @NotNull
    private Double weight;
}
