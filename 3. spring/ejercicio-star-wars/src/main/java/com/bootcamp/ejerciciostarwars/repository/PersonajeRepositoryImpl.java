package com.bootcamp.ejerciciostarwars.repository;

import com.bootcamp.ejerciciostarwars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository{
    @Override
    public List<Personaje> getPersonajes() {
        List<Personaje> personajes;

        try {
            ObjectMapper mapper = new ObjectMapper();
            personajes = mapper.readValue(new File("src/main/java/com/bootcamp/ejerciciostarwars/repository/starwars.json"), new TypeReference<List<Personaje>>() {});
        } catch (Exception e) {
            return new ArrayList<>();
        }

        return personajes;
    }
}
