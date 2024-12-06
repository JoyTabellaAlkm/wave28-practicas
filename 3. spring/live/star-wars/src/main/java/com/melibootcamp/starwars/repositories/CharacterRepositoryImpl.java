package com.melibootcamp.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.melibootcamp.starwars.entities.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository{
    private List<Character> characterList;
    private ObjectMapper objectMapper;


    public CharacterRepositoryImpl(){
        objectMapper = new ObjectMapper();
        try{
            String fileLocation = "src/main/resources/starwars.json";
            String WHATISIT = Files.readString(Path.of(fileLocation));
            characterList = objectMapper.readValue(
                    new File(fileLocation),
                    new TypeReference<List<Character>>() {});
        } catch (IOException e){
            System.out.println("COULDN'T READ JSON FILE");
        }
    }

    public List<Character> readAll(){
        return characterList;
    }
}
