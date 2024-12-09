package com.bootcamp.ejercicio_starwars.repository.Impl;

import com.bootcamp.ejercicio_starwars.entity.Personaje;
import com.bootcamp.ejercicio_starwars.repository.IPersonajeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {

    private List<Personaje> personajeList;
    private ObjectMapper objectMapper = new ObjectMapper();

    public PersonajeRepositoryImpl() {
        cargarPersonajes();
    }

    public List<Personaje> getPersonajesPorNombre(String nombre) {
        return personajeList.stream().filter(p -> p.getName().toLowerCase().contains(nombre.toLowerCase())).toList();
    }

    public void cargarPersonajes() {
        TypeReference<List<Personaje>> typeReference = new TypeReference<List<Personaje>>() {
        };

        try {
            InputStream inputStream =
                    new ClassPathResource("static/starwars.json").getInputStream();
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


}
