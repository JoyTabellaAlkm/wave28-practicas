package com.bootcamp.covid19.dto;

import com.bootcamp.covid19.model.Persona;
import lombok.Data;

import java.util.List;

@Data
public class PacienteDTO {
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<SintomaDTO> sintomasList;
}
