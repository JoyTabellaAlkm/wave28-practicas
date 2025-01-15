package com.meli.tienda.dto;

import lombok.*;

@Data
@ToString
public class PrendaDto {
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private int talle;
    private int cantidad;
    private Double precioVenta;
}
