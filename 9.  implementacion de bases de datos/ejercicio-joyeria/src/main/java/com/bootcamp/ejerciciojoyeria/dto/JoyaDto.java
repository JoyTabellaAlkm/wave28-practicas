package com.bootcamp.ejerciciojoyeria.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoyaDto {
    private String nombre;

    private String material;

    private double peso;

    private String particularidad;

    private boolean poseePiedra;

    private boolean ventaONo;
}
