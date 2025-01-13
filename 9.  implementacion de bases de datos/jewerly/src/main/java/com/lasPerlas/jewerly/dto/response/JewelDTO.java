package com.lasPerlas.jewerly.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelDTO {
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean ventaONo;
}
