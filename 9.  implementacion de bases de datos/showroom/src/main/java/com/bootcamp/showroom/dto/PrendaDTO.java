package com.bootcamp.showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrendaDTO {

    private String codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    int cantidad;
    private double precio;

}
