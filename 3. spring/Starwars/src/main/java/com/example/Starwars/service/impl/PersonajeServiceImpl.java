package com.example.Starwars.service.impl;

import com.example.Starwars.dto.PersonajeDto;
import com.example.Starwars.entity.Personaje;
import com.example.Starwars.repository.PersonajeRepository;
import com.example.Starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDto> findAllByName(String name) throws IOException {
        List<Personaje> personajes = personajeRepository.findAll();
        List<Personaje> encontrados = personajes.stream().filter(p -> p.getName().toUpperCase().contains(name.toUpperCase())).toList();
        return encontrados.stream().map(this::mapperDto).toList();
    }

    private PersonajeDto mapperDto(Personaje personaje){
        List.of();
        PersonajeDto personajeDto = new PersonajeDto(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getBirthYear(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies());
        return personajeDto;
    }
}

