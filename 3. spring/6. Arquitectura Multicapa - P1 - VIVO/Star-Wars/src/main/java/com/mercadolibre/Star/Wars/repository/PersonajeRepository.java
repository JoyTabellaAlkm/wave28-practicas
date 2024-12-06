package com.mercadolibre.Star.Wars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.mercadolibre.Star.Wars.model.Personaje;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class PersonajeRepository {

    private static final String FILE_PATH = "src/main/resources/static/starwars.json";

    public List<Personaje> getAllPersonaje() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try (FileInputStream inputStream = new FileInputStream(FILE_PATH)) {
            return objectMapper.readValue(inputStream, new TypeReference<List<Personaje>>() {});
        }
    }
}
