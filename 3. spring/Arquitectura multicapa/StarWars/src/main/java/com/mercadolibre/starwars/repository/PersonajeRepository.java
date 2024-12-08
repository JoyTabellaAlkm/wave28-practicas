package com.mercadolibre.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.model.Personaje;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;

@Repository
public class PersonajeRepository {
    private final List<Personaje> personajes;

    public PersonajeRepository() {
        this.personajes = loadPersonajes();
    }

    private List<Personaje> loadPersonajes() {
        try {
            // Cargar el archivo JSON desde resources
            InputStream inputStream = getClass().getResourceAsStream("/data.json");

            // Usar ObjectMapper para deserializar el JSON
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(inputStream, new TypeReference<List<Personaje>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error cargando los datos desde data.json", e);
        }
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

}
