package com.melibootcamp.empresadeseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoInfoDTO {
    private String patente;
    private String marca;
}
