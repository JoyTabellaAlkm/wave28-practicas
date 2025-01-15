package com.mercadolibre.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PrendaVentaDto {
    private Integer codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private int cantidad;
    @JsonProperty("precio_venta")
    private double precioVenta;
}
