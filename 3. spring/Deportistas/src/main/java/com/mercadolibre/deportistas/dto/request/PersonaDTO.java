package com.mercadolibre.deportistas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private Integer edad;
    private DeporteDTO deporteDTO;
}
