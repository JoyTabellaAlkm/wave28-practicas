package com.bootcamp.deportistas.mapper;

import com.bootcamp.deportistas.domain.Persona;
import com.bootcamp.deportistas.dto.PersonaDTO;

public class PersonaMapper {
    public static PersonaDTO mapToPersonaDTO(Persona persona) {
        return new PersonaDTO(persona.getNombre(),
                persona.getApellido(),
                persona.getEdad(),
                persona.getDeporte().getNombre() + " | Nivel " + persona.getDeporte().getNivel());
    }
}
