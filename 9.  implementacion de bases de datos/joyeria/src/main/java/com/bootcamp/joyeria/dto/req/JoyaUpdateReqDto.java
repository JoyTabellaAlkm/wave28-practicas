package com.bootcamp.joyeria.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JoyaUpdateReqDto {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;
    @JsonProperty("venta_o_no")
    private Boolean ventaONo;
}
