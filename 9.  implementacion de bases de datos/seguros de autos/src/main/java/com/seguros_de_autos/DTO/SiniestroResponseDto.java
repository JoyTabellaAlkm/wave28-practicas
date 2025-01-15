package com.seguros_de_autos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroResponseDto {
    private Long id;

    private LocalDate fechaDelSiniestro;

    private double perdidadEconomica;

    private String patente;
}
