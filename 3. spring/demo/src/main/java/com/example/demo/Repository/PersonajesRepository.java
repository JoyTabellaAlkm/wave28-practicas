package com.example.demo.Repository;

import com.example.demo.Model.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Data
public class PersonajesRepository {
    private List<Personaje> personajes = new ArrayList<>();
    private ObjectMapper objectMapper;

    @Autowired
    public PersonajesRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void cargarPersonajesDesdeArchivo() throws IOException {
        // Cargar el archivo JSON desde la carpeta resources
        ClassPathResource resource = new ClassPathResource("starwars.json");
        personajes = objectMapper.readValue(resource.getFile(), objectMapper.getTypeFactory().constructCollectionType(List.class, Personaje.class));
    }

    public List<Personaje> imprimir() {
        return personajes;
    }

    public String findByName(String name){
        String lowerName = name.toLowerCase();

        String result = personajes.stream()
                .filter(personaje -> {
                    String[] nameParts = personaje.getName().split(" ");// Ver los partes del nombre
                    return Arrays.stream(nameParts)
                            .anyMatch(part -> part.toLowerCase().contains(lowerName));
                })
                .map(Personaje::getName)
                .findFirst()
                .orElse(null);
        return result;
    }
}
