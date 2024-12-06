package com.mercadolibre.star_wars.repository;

import com.mercadolibre.star_wars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Data
@Repository
public class PersonajeRepository {
    private List<Personaje> personajes = new ArrayList<>();

    public List<Personaje> findAll() throws IOException {
        ObjectMapper mapeador= new ObjectMapper();
        personajes = mapeador.readValue(new File("src/main/resources/starwars.json"), new TypeReference<List<Personaje>>() {
        });
        return personajes;
    }
}
