package com.mercadolibre.starwars.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.model.Personaje;
import com.mercadolibre.starwars.repository.ICRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class PersonajeRepositoryImpl implements ICRUDRepository<Personaje> {
    private List<Personaje> listaPersonajes = new ArrayList<>();
    @Autowired
    private ObjectMapper  objectMapper = new ObjectMapper();

    @Override
    public List<Personaje> buscarPorNombre(String nombre) {
        if (cargarDatos()){

            return listaPersonajes.stream().filter(p->p.getName().toUpperCase()
                    .contains(nombre.toUpperCase())).toList();
        }
        return List.of();
    }

    private boolean cargarDatos(){
        try {
            listaPersonajes = objectMapper
                    .readValue(getClass()
                            .getResourceAsStream("/personajes.json")
                            , new TypeReference<List<Personaje>>() {});
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            listaPersonajes = List.of();
            return false;
        }
    }
}
