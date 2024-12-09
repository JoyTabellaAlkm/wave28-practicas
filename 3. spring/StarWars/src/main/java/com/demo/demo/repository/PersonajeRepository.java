package com.demo.demo.repository;

import com.demo.demo.dto.PersonajeDTO;
import com.demo.demo.model.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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

    private List<Personaje> populateFromFile() {
        try {
            Resource resource = new ClassPathResource("characters.json");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
            return objectMapper.readValue(
                    resource.getInputStream(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Personaje.class)
            );
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
