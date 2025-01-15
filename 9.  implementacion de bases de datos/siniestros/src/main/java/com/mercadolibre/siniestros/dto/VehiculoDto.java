package com.mercadolibre.siniestros.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDto {
    private String patente;
    private String marca;
    private String modelo;
    private int añoFabricacion;
    private int cantRuedas;
}
