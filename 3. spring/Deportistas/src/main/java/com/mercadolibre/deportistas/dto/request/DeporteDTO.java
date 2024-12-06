package com.mercadolibre.deportistas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeporteDTO {
    private String nombre;
    private String nivel;
}
