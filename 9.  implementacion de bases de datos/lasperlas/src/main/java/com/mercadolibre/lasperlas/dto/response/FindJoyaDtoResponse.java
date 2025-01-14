package com.mercadolibre.lasperlas.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindJoyaDtoResponse {

    @JsonAlias("nro_identificatorio")
    private long nroIdentificatorio;

    private String nombre;

    private String material;

    private double peso;

    private String particularidad;

    @JsonAlias("posee_piedra")
    private boolean poseePiedra;

    @JsonAlias("venta_o_no")
    private boolean ventaONo;

}
