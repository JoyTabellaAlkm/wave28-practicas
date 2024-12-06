package com.nombres.starwars.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nombres.starwars.dto.request.PersonajeDto;
import com.nombres.starwars.dto.response.NombreDtoResponse;
import com.nombres.starwars.model.Personaje;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NombreImpl implements INombre{

    private List<PersonajeDto> dataBase;

    @Override
    public List<NombreDtoResponse> obtenerNombre(String query) {
        dataBase = loadDataBase();
        List<NombreDtoResponse> respuestPersonajes = new ArrayList<>();
        List<PersonajeDto> personajesFiltados = dataBase.stream().filter( db -> matchWith(query, db)).toList();

        for(PersonajeDto persona: personajesFiltados){

            respuestPersonajes.add(new NombreDtoResponse(
                    persona.getName(),
                    persona.getHeight(),
                    persona.getMass(),
                    persona.getGender(),
                    persona.getHomeworld(),
                    persona.getSpecies()
            ));
        }

        return respuestPersonajes;
    }

    private boolean matchWith(String query, PersonajeDto nombreDto) {
        return nombreDto.getName().toUpperCase().contains(query.toUpperCase());
    }

    private List<PersonajeDto> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(file);
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeDto>> typeRef = new TypeReference<>() {};
        List<PersonajeDto> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(characters);
        return characters;
    }
}

