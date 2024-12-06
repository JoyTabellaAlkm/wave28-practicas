package com.bootcamp.ejerciciostarwars.repository;

import com.bootcamp.ejerciciostarwars.entity.Personaje;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public class PersonajeRepository {

    ObjectMapper objectMapper = new ObjectMapper();

    public List<Personaje> findPersonajeByName() throws IOException {
        return objectMapper.readValue(new File("/Users/sanmarino/IdeaProjects/ejercicio-starwars/src/main/resources/personajes.json"), new TypeReference<List<Personaje>>(){});
    }



}
