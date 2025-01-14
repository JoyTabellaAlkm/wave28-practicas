package com.mercadolibre.joyeria_las_perlas.dto.response;

import lombok.Data;

@Data
public class JoyaDTO {
    private long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean venta;
}
