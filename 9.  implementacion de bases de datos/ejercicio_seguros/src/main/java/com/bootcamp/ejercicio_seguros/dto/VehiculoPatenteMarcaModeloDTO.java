package com.bootcamp.ejercicio_seguros.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class VehiculoPatenteMarcaModeloDTO {
    private String patente;
    private String marca;
    private String modelo;
}
