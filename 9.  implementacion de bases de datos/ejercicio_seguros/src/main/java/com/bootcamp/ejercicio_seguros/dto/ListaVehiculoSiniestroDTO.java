package com.bootcamp.ejercicio_seguros.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class ListaVehiculoSiniestroDTO {
    private List<VehiculoSiniestroDTO> vehiculoSiniestroDTOS;
    private Double perdidaTotal;

    public ListaVehiculoSiniestroDTO(List<VehiculoSiniestroDTO> vehiculoSiniestroDTOS, Double perdidaTotal) {
        this.vehiculoSiniestroDTOS = vehiculoSiniestroDTOS;
        this.perdidaTotal = perdidaTotal;
    }
}
