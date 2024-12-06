package org.ejercicios.ejerciciosspring.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ejercicios.ejerciciosspring.dto.PersonajeDTO;
import org.ejercicios.ejerciciosspring.model.Personaje;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
