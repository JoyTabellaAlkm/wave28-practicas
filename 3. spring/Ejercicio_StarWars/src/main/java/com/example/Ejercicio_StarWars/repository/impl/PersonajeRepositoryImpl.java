package com.example.Ejercicio_StarWars.repository.impl;

import com.example.Ejercicio_StarWars.lista.ListaPersonaje;
import com.example.Ejercicio_StarWars.model.Personaje;
import com.example.Ejercicio_StarWars.repository.IPersonajeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {
    @Autowired
    private final ObjectMapper objectMapper;


    public PersonajeRepositoryImpl(ObjectMapper objectMapper, List<Personaje> listaPersonajes) {
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Personaje> listar() {
       try(InputStream inputStream = TypeReference.class.getResourceAsStream("src/main/resources/starwars.json")){
            ListaPersonaje listaPersonaje = objectMapper.readValue(inputStream, ListaPersonaje.class);
           return listaPersonaje.personajes();
       } catch (IOException e) {
        throw new RuntimeException("Failed to read JSON data.");
    }
    }
}
