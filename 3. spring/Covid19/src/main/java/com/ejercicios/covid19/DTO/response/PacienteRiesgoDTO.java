package com.ejercicios.covid19.DTO.response;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PacienteRiesgoDTO {
    private String nombre;
    private String apellido;


    public PacienteRiesgoDTO(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
