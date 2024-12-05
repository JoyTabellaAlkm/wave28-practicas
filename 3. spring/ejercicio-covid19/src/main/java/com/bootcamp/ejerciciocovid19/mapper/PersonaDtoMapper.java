package com.bootcamp.ejerciciocovid19.mapper;

import com.bootcamp.ejerciciocovid19.dto.PersonaRiesgoDto;
import com.bootcamp.ejerciciocovid19.model.Persona;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonaDtoMapper {
    public PersonaRiesgoDto mapPersonaRiesgo(Persona persona) {
        return new PersonaRiesgoDto(persona.getNombre(), persona.getApellido(), persona.getEdad());
    }

    public List<PersonaRiesgoDto> mapPersonasRiesgo(List<Persona> personas) {
        return personas.stream().map(this::mapPersonaRiesgo).collect(Collectors.toList());
    }
}
