package com.spring.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.spring.starwars.model.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class PersonajeRepository  {

    private List<Personaje> personajeList = initDb();


    public List<Personaje> findBy(String name) {
        return personajeList.stream()
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
