package com.lasPerlas.jewerly.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewJewelDTO {
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean ventaONo;
}
