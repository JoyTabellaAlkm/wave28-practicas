package com.mercadolibre.siniestros.dto;

import com.mercadolibre.siniestros.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoSiniestroDto {
    private Vehiculo vehiculo;
    private Double perdidaTotal;

}
