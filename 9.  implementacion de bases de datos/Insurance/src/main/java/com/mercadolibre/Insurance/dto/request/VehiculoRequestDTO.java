package com.mercadolibre.Insurance.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoRequestDTO {
    private String patente;
    private String marca;
    private String modelo;
    private int ano;
    private int ruedas;
}
