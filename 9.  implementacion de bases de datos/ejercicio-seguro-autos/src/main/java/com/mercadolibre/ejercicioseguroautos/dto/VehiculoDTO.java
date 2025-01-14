package com.mercadolibre.ejercicioseguroautos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {

    private String patente;
    private String marca;
    private String modelo;

    @JsonProperty("fecha_fabricacion")
    private LocalDate fechaFabricacion;

    @JsonProperty("cantidad_de_ruedas")
    private Integer cantidadDeRuedas;
}
