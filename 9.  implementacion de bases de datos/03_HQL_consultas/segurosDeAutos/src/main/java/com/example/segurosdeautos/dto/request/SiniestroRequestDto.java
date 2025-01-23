package com.example.segurosdeautos.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroRequestDto {
    @JsonProperty("fecha_siniestro")
    private LocalDate fechaSiniestro;
    @JsonProperty("perdida_economica")
    private Double perdidaEconomica;
    @JsonProperty("vehiculo_id")
    private Long vehiculoId;
}
