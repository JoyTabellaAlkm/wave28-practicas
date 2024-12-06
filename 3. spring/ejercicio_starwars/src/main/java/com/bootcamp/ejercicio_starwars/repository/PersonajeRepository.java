package com.bootcamp.ejercicio_starwars.repository;

import com.bootcamp.ejercicio_starwars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Repository
public class PersonajeRepository {
    private final List<Personaje> DATA = initDb();

    public List<Personaje> findBy(String name) {
        return DATA.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    private static List<Personaje> initDb() {
        try {
            File file = ResourceUtils.getFile("classpath:starwars.json");
            ObjectMapper objectMapper = new ObjectMapper()
                    .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);;
            return objectMapper.readValue(file, new TypeReference<List<Personaje>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

}
