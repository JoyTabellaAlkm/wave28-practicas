package com.bootcamp.LasPerlas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoyaDto {
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean ventaONo;
}
