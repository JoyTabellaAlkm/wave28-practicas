package com.bootcamp.joyerialasperlas.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateJoyaDTO {
    String nombre;

    String material;

    double peso;

    String particularidad;

    @JsonProperty("posee_piedra")
    boolean poseePiedra;

    @JsonProperty("venta_o_no")
    boolean ventaONo;
}
