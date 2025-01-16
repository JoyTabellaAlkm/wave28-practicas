package com.mercadolibre.elasticsearch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductoDto {

    private String nombre;
    private String tipo;

    @JsonProperty("precio_venta")
    private double precioVenta;

    @JsonProperty("precio_costo")
    private String precioCosto;

    @JsonProperty("cantidad_disponible")
    private String cantidadDisponible;

}
