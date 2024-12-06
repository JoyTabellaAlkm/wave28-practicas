package com.bootcamp.deportistas.dto;

import com.bootcamp.deportistas.model.Persona;
import lombok.Data;

@Data
public class DeportistaDTO {
    private String fullName;
    private String sportName;

    public DeportistaDTO(Persona persona) {
        this.fullName = persona.getFullName();
        this.sportName = persona.getDeporteName();
    }
}