package com.mercadolibre.siniestros.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSiniestroDto {

    @JsonProperty("perdida_economica")
    private double perdidaEconomica;

    @JsonProperty("vehiculo_id")
    private long vehiculoId;

}
