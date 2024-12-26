package com.bootcamp.ejerciciojoyeria.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestJoyaDto {
    private String nombre;

    private String material;

    private double peso;

    private String particularidad;

    @JsonAlias("posee_piedra")
    private boolean poseePiedra;

    @JsonAlias("venta_o_no")
    private boolean ventaONo;
}
