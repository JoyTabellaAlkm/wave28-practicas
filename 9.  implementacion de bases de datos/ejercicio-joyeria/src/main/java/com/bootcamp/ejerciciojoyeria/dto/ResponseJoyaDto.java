package com.bootcamp.ejerciciojoyeria.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseJoyaDto {
    private String nombre;

    private String material;

    private double peso;

    private String particularidad;

    @JsonProperty("posee_piedra")
    @JsonAlias("poseePiedra")
    private boolean poseePiedra;

    @JsonProperty("venta_o_no")
    @JsonAlias("ventaONo")
    private boolean ventaONo;
}
