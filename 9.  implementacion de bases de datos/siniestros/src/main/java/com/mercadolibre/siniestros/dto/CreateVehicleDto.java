package com.mercadolibre.siniestros.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateVehicleDto {

    private String patente;
    private String marca;
    private String modelo;

    @JsonProperty("anio_fabricacion")
    private LocalDate anioFabricacion;

    @JsonProperty("cantidad_ruedas")
    private int cantidadRuedas;

}
