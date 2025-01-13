package com.bootcamp.joyerialasperlas.dto.response;

import lombok.Data;

@Data
public class JoyaDTO {
    Long nroIdentificatorio;

    String nombre;

    String material;

    double peso;

    String particularidad;

    boolean poseePiedra;

    boolean ventaONo;
}
