package com.bootcamp.SegurosAutos.dto;

import com.bootcamp.SegurosAutos.entity.Vehiculo;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SiniestroDto {
    @JsonProperty("fecha_siniestro")
    LocalDate fechaSiniestro;
    @JsonProperty("perdida_economica")
    Double perdidaEconomica;
}
