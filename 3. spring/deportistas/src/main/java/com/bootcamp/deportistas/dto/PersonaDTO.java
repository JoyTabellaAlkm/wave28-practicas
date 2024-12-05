package com.bootcamp.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String deporte;
}
