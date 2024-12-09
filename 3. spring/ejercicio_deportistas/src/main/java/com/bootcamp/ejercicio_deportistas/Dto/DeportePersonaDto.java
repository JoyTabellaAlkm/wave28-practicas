package com.bootcamp.ejercicio_deportistas.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class DeportePersonaDto implements Serializable {
    private String nombre;
    private String apellido;
    private String deporteNombre;

}
