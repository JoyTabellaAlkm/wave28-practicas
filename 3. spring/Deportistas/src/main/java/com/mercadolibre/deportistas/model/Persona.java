package com.mercadolibre.deportistas.model;

import lombok.Data;

@Data
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private Deporte deporte;
}
