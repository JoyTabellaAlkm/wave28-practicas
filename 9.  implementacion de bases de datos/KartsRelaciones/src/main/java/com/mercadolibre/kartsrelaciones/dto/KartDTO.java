package com.mercadolibre.kartsrelaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class KartDTO {

    private String modelo;
    private int velocidadMaxima;
    private PilotDTO piloto;

}