package org.bootcampmeli.ejerciciodeportistas.model;


import lombok.*;

@AllArgsConstructor
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;

}
