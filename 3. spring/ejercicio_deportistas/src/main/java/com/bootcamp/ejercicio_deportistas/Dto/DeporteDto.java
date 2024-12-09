package com.bootcamp.ejercicio_deportistas.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class DeporteDto implements Serializable {
    public String nombre;
    public String nivel;
}
