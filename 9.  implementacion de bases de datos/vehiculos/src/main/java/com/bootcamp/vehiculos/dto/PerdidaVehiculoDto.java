package com.bootcamp.vehiculos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerdidaVehiculoDto {
    String patente;
    String marca;
    String modelo;
    Double perdida;
}
