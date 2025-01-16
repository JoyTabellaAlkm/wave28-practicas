package com.mercadolibre.elasticsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmpleadoDto {

    private String nombre;
    private String apellido;
    private short edad;
    private String ciudad;
    private String departamento;

}
