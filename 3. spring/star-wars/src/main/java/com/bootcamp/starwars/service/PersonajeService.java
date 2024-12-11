package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDto;
import com.bootcamp.starwars.model.Personaje;
import com.bootcamp.starwars.repository.IPersonajeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService implements IPersonajeService {
    private final IPersonajeRepository personajeRepository;

    public PersonajeService(IPersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDto> searchPersonajes() {
        ObjectMapper mapper = new ObjectMapper();
        List<Personaje> personajes = personajeRepository.findAll();

        return personajes.stream()
                .map(personaje -> mapper.convertValue(personaje, PersonajeDto.class))
                .toList();
    }
}
