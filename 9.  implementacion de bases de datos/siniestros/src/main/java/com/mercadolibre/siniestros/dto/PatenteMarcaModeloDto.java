package com.mercadolibre.siniestros.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaModeloDto {
    private String patente;
    private String marca;
    private String modelo;
}
