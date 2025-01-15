package com.bootcamp.joyeria.dto.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JoyaCreationResDto {
    @JsonProperty("nro_identificatorio")
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;
    @JsonProperty("venta_o_no")
    private Boolean ventaONo;
}
