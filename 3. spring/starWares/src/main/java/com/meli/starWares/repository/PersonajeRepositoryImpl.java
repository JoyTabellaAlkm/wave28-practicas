package com.meli.starWares.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starWares.model.PersonajeModel;
//import org.springframework.asm.TypeReference;
import org.springframework.asm.TypeReference;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository{
    private final String DATA_FILE = "src/main/resources/starwars.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<PersonajeModel> getAllPersonajes() throws IOException {

        return objectMapper.readValue(new File(DATA_FILE), new TypeReference<List<PersonajeModel>>(){});
    }

}