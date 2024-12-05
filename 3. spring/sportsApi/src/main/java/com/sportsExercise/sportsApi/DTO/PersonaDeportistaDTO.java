package com.sportsExercise.sportsApi.DTO;

import lombok.Data;

@Data
public class PersonaDeportistaDTO {
    private String nombre;
    private String apellido;
    private String deporte;

    public PersonaDeportistaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }
}
