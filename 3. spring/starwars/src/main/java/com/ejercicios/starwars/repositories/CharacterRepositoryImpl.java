package com.ejercicios.starwars.repositories;

import com.ejercicios.starwars.models.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository{

    public CharacterRepositoryImpl() {}

    @Override
    public List<Character> getCharactersByName(String name) {

        List<Character> characters1 = new ArrayList<>();
        try (InputStream json = new ClassPathResource("starwars.json").getInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            characters1 = objectMapper.readValue(json, new TypeReference<>() {});
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return characters1.stream().filter(character -> character.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }
}