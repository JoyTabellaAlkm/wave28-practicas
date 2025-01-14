package com.example.segurosdeautos.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoRequestDto {
    private String patente;
    private String marca;
    private String modelo;
    @JsonProperty("anio_fabricacion")
    private LocalDate anioFabricacion;
    @JsonProperty("cantidad_ruedas")
    private int cantidadRuedas;
}
