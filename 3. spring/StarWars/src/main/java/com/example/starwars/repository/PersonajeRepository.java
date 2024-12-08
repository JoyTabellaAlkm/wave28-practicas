package com.example.starwars.repository;

import com.example.starwars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;

@Repository
public class PersonajeRepository {

    public List<Personaje> getAllPersonajes() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getResourceAsStream("/starwars.json")) {
            return mapper.readValue(is, new TypeReference<List<Personaje>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo JSON", e);
        }
    }
}