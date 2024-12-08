package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.model.Personaje;
import com.example.starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {

    private final PersonajeRepository repository;

    @Autowired
    public PersonajeService(PersonajeRepository repository) {
        this.repository = repository;
    }

    public List<PersonajeDTO> findPersonajesByName(String namePart) {
        List<Personaje> personajes = repository.getAllPersonajes();
        return personajes.stream()
                .filter(personaje -> personaje.getName().contains(namePart))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PersonajeDTO convertToDTO(Personaje personaje) {
        PersonajeDTO dto = new PersonajeDTO();
        dto.setName(personaje.getName());
        dto.setHeight(personaje.getHeight());
        dto.setMass(personaje.getMass());
        dto.setGender(personaje.getGender());
        dto.setHomeworld(personaje.getHomeworld());
        dto.setSpecies(personaje.getSpecies());
        return dto;
    }
}
