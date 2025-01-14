package com.melibootcamp.empresadeseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaMatriculaModeloDTO {
    private String matricula;
    private String marca;
    private String modelo;
}
