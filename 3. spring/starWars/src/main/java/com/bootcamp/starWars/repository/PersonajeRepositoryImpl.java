package com.bootcamp.starWars.repository;

import com.bootcamp.starWars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {

    @Autowired
    ObjectMapper objectMapper;

    private final String DATA_FILE = "src/main/resources/starwars.json";

    public List<Personaje> getAllPersonajes() throws IOException {
        return objectMapper.readValue(new File(DATA_FILE), new TypeReference<List<Personaje>>(){});
    }

}
