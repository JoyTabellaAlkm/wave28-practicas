package com.ejercicio.starwars.repository;

import com.ejercicio.starwars.entity.Characters;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class CharactersDAO {
    public List<Characters> characters;
    public void cargarDatos(){
        try{
            File file = ResourceUtils.getFile("classpath:starwars.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            characters = mapper.readValue(file, new TypeReference<List<Characters>>(){});
        } catch(Exception e){
            System.out.println(e.getMessage());
            characters = Collections.emptyList();
        }
        System.out.println(characters);

    };

    public CharactersDAO() {
        cargarDatos();
    }
    public List<Characters> FindCharacters(String name){
        return characters.stream().filter(c -> c.getName().contains(name)).toList();
    }
}
