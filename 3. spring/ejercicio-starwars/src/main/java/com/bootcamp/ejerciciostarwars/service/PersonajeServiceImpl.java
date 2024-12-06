package com.bootcamp.ejerciciostarwars.service;

import com.bootcamp.ejerciciostarwars.dto.PersonajeDTO;
import com.bootcamp.ejerciciostarwars.entity.Personaje;
import com.bootcamp.ejerciciostarwars.repository.PersonajeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDTO> findPersonajeByName(String name) throws IOException {

       List<Personaje> personajes = personajeRepository.findPersonajeByName();

        // Filtra la lista para encontrar el personaje por nombre
        List<Personaje> personajesFiltrados = personajes.stream()
                .filter(personaje -> personaje.getName().contains(name))
                .toList(); // Devuelve una lista de coincidencias (puede ser vacía)

        List<PersonajeDTO> personajeDTOs = new ArrayList<>();
        for(Personaje personaje: personajesFiltrados) {
            personajeDTOs.add(new PersonajeDTO(
                    personaje.getName(), personaje.getHeight(),
                    personaje.getMass(), personaje.getGender(),
                    personaje.getHomeworld(), personaje.getSpecies()
            ));
        }

        return personajeDTOs;

    }

}
