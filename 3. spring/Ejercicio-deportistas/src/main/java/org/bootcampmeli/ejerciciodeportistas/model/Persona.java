package org.bootcampmeli.ejerciciodeportistas.model;


import lombok.*;
import org.bootcampmeli.ejerciciodeportistas.dto.DeportistaDTO;

@AllArgsConstructor
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;

    public DeportistaDTO toDTO() {
        return new DeportistaDTO(nombre,apellido, deporte.getNombre());
    }

    public Persona toEntity() {
        return new Persona(nombre, apellido, edad, deporte);
    }

}
