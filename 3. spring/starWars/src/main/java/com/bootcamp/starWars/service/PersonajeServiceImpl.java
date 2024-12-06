package com.bootcamp.starWars.service;

import com.bootcamp.starWars.dto.PersonajeDTO;
import com.bootcamp.starWars.repository.PersonajeRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    PersonajeRepositoryImpl personajeRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<PersonajeDTO> getPersonajesByName(String name) throws IOException {

       return personajeRepository.getAllPersonajes().stream().filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase()))
               .map(personaje -> objectMapper.convertValue(personaje, PersonajeDTO.class)).toList();

    }

}
