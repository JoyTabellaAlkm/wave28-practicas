package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository implements IPersonajeRepository {
    private List<Personaje> personajes = new ArrayList<>();

    public PersonajeRepository() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Personaje> findAll() {
        return personajes;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        file = ResourceUtils.getFile("classpath:starwars.json");
        personajes = objectMapper.readValue(file, new TypeReference<>() {
        });
    }
}
