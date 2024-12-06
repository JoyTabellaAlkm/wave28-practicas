package com.mercadolibre.star_wars.service.impl;

import com.mercadolibre.star_wars.dto.PersonajeDTO;
import com.mercadolibre.star_wars.entity.Personaje;
import com.mercadolibre.star_wars.repository.PersonajeRepository;
import com.mercadolibre.star_wars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {
    @Autowired
    private PersonajeRepository repository;

    @Override
    public List<PersonajeDTO> findAllByName(String name) throws IOException {
        List<Personaje> personajes = repository.findAll();
        List<Personaje> encontrados = personajes.stream().filter(p -> p.getName().toUpperCase().contains(name.toUpperCase())).toList();
        return encontrados.stream().map(this::mapearaDTO).toList();
    }

    private PersonajeDTO mapearaDTO(Personaje personaje) {
        PersonajeDTO personajeDTO = new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getBirthYear(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies());
        return personajeDTO;
    }
}
