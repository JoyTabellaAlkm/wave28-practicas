package com.ejercicios.covid19.DTO.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PacienteRiesgoDTO {
    private String nombre;
    private String apellido;


}
