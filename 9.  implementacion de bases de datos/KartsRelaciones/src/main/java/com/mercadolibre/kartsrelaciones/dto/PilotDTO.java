package com.mercadolibre.kartsrelaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PilotDTO {

    private String nombre;
    private int edad;
    private KartDTO kart;
    private Set<RaceDTO> carreras;
}