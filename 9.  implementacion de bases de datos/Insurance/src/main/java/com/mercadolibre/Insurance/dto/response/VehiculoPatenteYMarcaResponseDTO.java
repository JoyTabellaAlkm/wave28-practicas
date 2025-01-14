package com.mercadolibre.Insurance.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoPatenteYMarcaResponseDTO {
    private String marca;
    private String patente;
}
