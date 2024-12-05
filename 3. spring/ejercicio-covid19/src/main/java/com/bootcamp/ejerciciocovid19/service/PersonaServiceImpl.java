package com.bootcamp.ejerciciocovid19.service;

import com.bootcamp.ejerciciocovid19.dto.PersonaRiesgoDto;
import com.bootcamp.ejerciciocovid19.mapper.PersonaDtoMapper;
import com.bootcamp.ejerciciocovid19.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements IPersonaService{
    @Autowired
    PersonaDtoMapper personaDtoMapper;

    List<Persona> personas = new ArrayList<>(List.of(
            new Persona(123, "Jose", "Perez", 18),
            new Persona(123, "Julian", "Sanchez", 16),
            new Persona(122, "Pepe", "Suarez", 61),
            new Persona(122, "Carlos", "Gomez", 60)

    ));
    @Override
    public List<PersonaRiesgoDto> buscarPoblacionDeRiesgo() {
        return personas.
                stream().
                filter(p -> p.getEdad() >= 60).
                map(p -> personaDtoMapper.mapPersonaRiesgo(p)).
                collect(Collectors.toList());
    }
}
