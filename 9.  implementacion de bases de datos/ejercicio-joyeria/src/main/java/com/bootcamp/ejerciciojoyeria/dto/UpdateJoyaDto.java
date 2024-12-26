package com.bootcamp.ejerciciojoyeria.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateJoyaDto {
    private String nombre;

    private String material;

    private double peso;

    private String particularidad;

    @JsonAlias("posee_piedra")
    private boolean poseePiedra;

    @JsonAlias("venta_o_no")
    private boolean ventaONo;
}
