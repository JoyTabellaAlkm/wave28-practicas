package com.mercadolibre.covid19.dto;

import com.mercadolibre.covid19.model.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private int edad;
    private List<SintomaNombreDTO> sintomas;
}
