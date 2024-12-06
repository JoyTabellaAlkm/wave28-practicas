package com.bootcamp.starWars.service;

import com.bootcamp.starWars.dto.PersonajeDTO;
import com.bootcamp.starWars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class StarWarsImpl {
    public List<PersonajeDTO> buscarPersonajesPorNombre(String name) {

         List<Personaje> personajes = new ArrayList<Personaje>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Leer el archivo JSON y deserializar en UsuarioList

            personajes = objectMapper.readValue(new File("src/main/resources/starwars.json"), new TypeReference<List<Personaje>>() {});

            personajes = personajes.stream().filter(personaje -> personaje.getName().contains(name)).toList();




        } catch (IOException e) {
            e.printStackTrace(); // Manejo de la excepción
        }


return  personajes.stream().map(personaje -> new PersonajeDTO(personaje.getName(), personaje.getSpecies(), personaje.getHomeworld(), personaje.getGender(), personaje.getMass(), personaje.getHeight())).toList();
    }

}
