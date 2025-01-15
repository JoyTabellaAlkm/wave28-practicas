package com.example.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class PrendaDto {
    String nombre;
    String tipo;
    String marca;
    String color;
    String talle;
    Integer cantidad;
    @JsonProperty("precio_venta")
    Double precioVenta;
}
