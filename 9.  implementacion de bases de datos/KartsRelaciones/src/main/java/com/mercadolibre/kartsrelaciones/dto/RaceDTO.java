package com.mercadolibre.kartsrelaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class RaceDTO {

    private String nombre;
    private LocalDate fecha;
    private CountryDTO pais;
    private Set<PilotDTO> pilotos;

}