package com.mercadolibre.ejercicioseguroautos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.ejercicioseguroautos.models.Vehiculo;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroDTO {

    @JsonProperty("fecha_siniestro")
    private LocalDate fechaSiniestro;

    @JsonProperty("perdida_economica")
    private Double perdidaEconomica;

    @JsonProperty("id_vehiculo")
    private Long idVehiculo;

    @Override
    public String toString() {
        return "SiniestroDTO{" +
                "fechaSiniestro=" + fechaSiniestro +
                ", perdidaEconomica=" + perdidaEconomica +
                ", idVehiculo=" + idVehiculo +
                '}';
    }
}
