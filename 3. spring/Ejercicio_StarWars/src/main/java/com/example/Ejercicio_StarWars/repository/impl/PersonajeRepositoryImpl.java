package com.example.Ejercicio_StarWars.repository.impl;

import com.example.Ejercicio_StarWars.model.Personaje;
import com.example.Ejercicio_StarWars.repository.IPersonajeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {

    @Override
    public List<Personaje> listar() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("starwars.json")) {
            if (inputStream == null) {
                throw new RuntimeException("JSON no encontrado.");
            }
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
            List<Personaje> personajes = null;
            try {
                personajes = objectMapper.readValue(inputStream, typeRef);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return personajes;
        } catch (IOException e) {
            throw new RuntimeException("Error al acceder al JSON.", e);
        }


    }


}
