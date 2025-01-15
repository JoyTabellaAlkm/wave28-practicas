package com.example.seguros_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestVehiculoDto {
    @JsonProperty("patente")
    private String patente;

    @JsonProperty("marca")
    private String marca;

    @JsonProperty("modelo")
    private String modelo;

    @JsonProperty("anio_fabricacion")
    private Integer anioFabricacion;

    @JsonProperty("cantidad_ruedas")
    private String cantidadRuedas;
}
