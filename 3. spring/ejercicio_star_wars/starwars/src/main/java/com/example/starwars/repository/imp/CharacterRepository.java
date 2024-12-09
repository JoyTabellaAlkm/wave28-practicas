package com.example.starwars.repository.imp;

import com.example.starwars.repository.ICharacerRepository;
import com.example.starwars.entity.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class CharacterRepository implements ICharacerRepository {

    public List<Character> getCharacters() {
        List<Character> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        TypeReference<List<Character>> typeRef = new TypeReference<List<Character>>() {
        };
        try {
            file = new ClassPathResource("starwars.json").getFile();

            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return data;
    }

    @Override
    public List<Character> getCharactersByName(String name) {
        return getCharacters().stream()
                .filter(x -> (x.getName().toLowerCase()).contains(name))
                .toList();
    }
}
