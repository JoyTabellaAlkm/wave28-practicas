package com.mercadolibre.siniestros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaModeloVehicleDto {

    private String patente;
    private String marca;
    private String modelo;

}
