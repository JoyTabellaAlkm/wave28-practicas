package org.bootcampmeli.ejerciciostarwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcampmeli.ejerciciostarwars.model.Personaje;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;


@Repository
public class StarWarsRepository {

    private List<Personaje> personajeList; // Inicialización segura por defecto.

    public StarWarsRepository() {
        loadCharacters();
    }

    public void loadCharacters() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeReference = new TypeReference<List<Personaje>>() {};

        try (InputStream inputStream = new ClassPathResource("static/starwars.json").getInputStream()) {
            personajeList = objectMapper.readValue(inputStream, typeReference);
            if (personajeList != null) {
                System.out.println("Datos cargados, número de personajes: " + personajeList.size());
            }
        } catch (IOException e) {
            System.err.println("Error cargando los personajes: " + e.getMessage());
            e.printStackTrace();
            personajeList = List.of();
        }
    }

    public List<Personaje> getPersonajeList() {
        return personajeList;
    }


    public List<Personaje> getByName(String name) {

        return personajeList.stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();


    }
}