package com.example.starwars.repository;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.entity.CharacterE;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Repository
public class CharacterRepository implements IRepository<CharacterE> {
    @Override
    public List<CharacterE> findByName(String name) {
        List<CharacterE> database = loadDataBase();
        List<CharacterE> filteredCharacters;

        List<CharacterE> databaseFilter = database.stream().filter(
                r -> !Objects.equals(r.getHeight(), "NA") || !Objects.equals(r.getMass(), "NA")).toList();

        filteredCharacters = databaseFilter.stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();

        return filteredCharacters;
    }

    private static List<CharacterE> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterE>> typeRef = new TypeReference<>() {};
        List<CharacterE> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
