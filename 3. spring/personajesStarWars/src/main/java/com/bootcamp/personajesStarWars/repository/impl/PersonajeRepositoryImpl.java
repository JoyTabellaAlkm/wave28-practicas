package com.bootcamp.personajesStarWars.repository.impl;

import com.bootcamp.personajesStarWars.dto.PersonajeDTO;
import com.bootcamp.personajesStarWars.model.Personaje;
import com.bootcamp.personajesStarWars.repository.PersonajeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository {

    @Override
    public List<Personaje> findByName(String name) {
        List<Personaje> data = loadDataBase();

        return data.stream().filter(p-> p.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    private static List<Personaje> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        List<Personaje> personajes=null;
        try{
            personajes = objectMapper.readValue(file,new TypeReference<List<Personaje>>(){});
        } catch (IOException e){
            e.printStackTrace();
        }
        return personajes;
    }
}
