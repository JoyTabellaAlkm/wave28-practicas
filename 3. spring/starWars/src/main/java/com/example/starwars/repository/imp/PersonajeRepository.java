package com.example.starwars.repository.imp;

import com.example.starwars.model.Personaje;
import com.example.starwars.repository.IRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository implements IRepository {

    private List<Personaje> listaPersonajes = new ArrayList<>();
    @Autowired
    private ObjectMapper  objectMapper = new ObjectMapper();

    @Override
    public List<Personaje> buscarPorNombre(String nombre) {
        if (cargarDatos()){
            return listaPersonajes.stream()
                    .filter(p -> p.getName().toLowerCase()
                            .contains(nombre.toLowerCase())).toList();
        }
        return List.of();
    }
    private boolean cargarDatos(){
        try {
            objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

            listaPersonajes = objectMapper
                    .readValue(getClass()
                                    .getResourceAsStream("/starwars.json")
                            , new TypeReference<List<Personaje>>() {});
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            listaPersonajes = List.of();
            return false;
        }
    }
}
