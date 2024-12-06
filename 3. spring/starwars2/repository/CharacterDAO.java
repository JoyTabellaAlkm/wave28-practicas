package com.example.starwars2.repository;

import com.example.starwars2.entity.CharacterEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Repository
public class CharacterDAO {
    public List<CharacterEntity> characters;

    public CharacterDAO(){
        try{
            File file = ResourceUtils.getFile("classpath:starwars.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            characters = mapper.readValue(file, new TypeReference<List<CharacterEntity>>(){});
        } catch(Exception e){
            System.out.println(e.getMessage());
            characters = Collections.emptyList();
        }
        System.out.println(characters);
    }

    public List<CharacterEntity> FindCharacters(String name){
        System.out.println(name);
        return characters.stream().filter(c -> c.getName().contains(name)).toList();
    }

}
