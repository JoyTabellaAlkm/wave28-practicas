package com.demo.demo.repository;

import com.demo.demo.dto.PersonajeDTO;
import com.demo.demo.model.Personaje;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class PersonajeRepository {
    List<Personaje> personajes;

    public PersonajeRepository() {
        this.personajes = populateFromFile();
    }

    public List<PersonajeDTO> getPersonajes(String name) {
        List<Personaje> personajesResultado = personajes.stream()
                .filter(personaje -> personaje.getName().contains(name))
                .toList();
        return personajesResultado.stream()
                .map(this::crearPersonajeDTO)
                .toList();
    }

    public PersonajeDTO crearPersonajeDTO(Personaje p) {
        PersonajeDTO personaje = new PersonajeDTO();
        personaje.setName(p.getName());
        personaje.setHeight(p.getHeight());
        personaje.setMass(p.getMass());
        personaje.setGender(p.getGender());
        personaje.setHomeworld(p.getHomeworld());
        personaje.setSpecies(p.getSpecies());
        return personaje;
    }

    public List<Personaje> populateFromFile() {
        List<Personaje> personajes = new ArrayList<>();
        personajes.add(new Personaje(
                "Luke Skywalker",
                72,
                7,
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human"
        ));
        personajes.add(new Personaje(
                "C-3PO",
                167,
                75,
                "NA",
                "gold",
                "yellow",
                "112BBY",
                "NA",
                "Tatooine",
                "Droid"
        ));
        return personajes;
    }
}
