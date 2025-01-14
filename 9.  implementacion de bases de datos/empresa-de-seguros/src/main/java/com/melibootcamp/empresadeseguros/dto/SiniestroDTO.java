package com.melibootcamp.empresadeseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroDTO {
    private Long id;
    private String fechaSiniestro;
    private Double perdidaEconomica;
    private Long vehiculoId;
    private String vehiculoPatente;
}