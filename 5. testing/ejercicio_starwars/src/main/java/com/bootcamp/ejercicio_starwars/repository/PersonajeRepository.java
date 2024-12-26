package com.bootcamp.ejercicio_starwars.repository;

import com.bootcamp.ejercicio_starwars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

@Repository
public class PersonajeRepository {

    private String SCOPE;

    private List<Personaje> DATA;

    private PersonajeRepository() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.initDb();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Personaje> findBy(String name) {
        return DATA.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    private List<Personaje> initDb() {
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/starwars.json");
            ObjectMapper objectMapper = new ObjectMapper()
                    .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);;
            DATA = objectMapper.readValue(file, new TypeReference<List<Personaje>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

}
