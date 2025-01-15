package com.ar.mercadolibre.showroom.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClotheDTO {

    private Long codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talla;
    private int cantidad;
    @JsonProperty("precio_venta")
    private double precioVenta;
}
