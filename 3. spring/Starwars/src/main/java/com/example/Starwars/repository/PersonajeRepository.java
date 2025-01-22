package com.example.Starwars.repository;

import com.example.Starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
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

    public List<Personaje> findAll() throws IOException{
        ObjectMapper mapper = new ObjectMapper();

        personajes = mapper.readValue(new File("src/main/resources/starwars2.json"), new TypeReference<List<Personaje>>() {
        });
        return personajes;
    }


}
