package com.mercadolibre.Insurance.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoResponseDTO {
    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private int ruedas;
    private List<SiniestroResponseDTO> siniestros;
}
