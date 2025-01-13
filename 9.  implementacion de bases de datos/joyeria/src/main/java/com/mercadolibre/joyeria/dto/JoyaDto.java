package com.mercadolibre.joyeria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDto {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private boolean poseePiedra;
    @JsonProperty("venta_ono")
    private boolean ventaONo;
}
