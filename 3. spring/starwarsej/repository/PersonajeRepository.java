package com.mercadolibre.starwarsej.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwarsej.model.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

@Repository
public class PersonajeRepository implements IPersonajeRepository {

    @Override
    public List<Personaje> loadPersonajes() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Personaje> listaPersonajes = new ArrayList<>();

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // Leer el archivo JSON y convertirlo a ArrayList
            listaPersonajes = objectMapper.readValue(file, new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaPersonajes;
    }
}
