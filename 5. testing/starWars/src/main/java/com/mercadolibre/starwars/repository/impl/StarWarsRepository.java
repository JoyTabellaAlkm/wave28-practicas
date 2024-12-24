package com.mercadolibre.starwars.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.model.Character;
import com.mercadolibre.starwars.repository.IStarWarsRepository;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StarWarsRepository implements IStarWarsRepository {

    private List<Character> characters = new ArrayList<>();

    public StarWarsRepository() {

        ObjectMapper objectMapper = new ObjectMapper();
        try (FileInputStream inputStream = new FileInputStream("src/main/resources/static/starwars.json")) {
            this.characters = objectMapper.readValue(inputStream, new TypeReference<List<Character>>() {});
        } catch (Exception e) {
            System.out.println("Error cargando personajes:" + e.getMessage());
        }

    }
    @Override
    public List<Character> getCharacters() {
        return characters;
    }
}
