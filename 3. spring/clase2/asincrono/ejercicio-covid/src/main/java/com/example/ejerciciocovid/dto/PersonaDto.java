package com.example.ejerciciocovid.dto;

import com.example.ejerciciocovid.model.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonaDto {
    private String nombre;
    private String apellido;
    private List<SintomaDto> sintomas;
}
