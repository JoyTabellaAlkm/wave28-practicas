package com.example.starwars.service.impl;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.entity.Personaje;
import com.example.starwars.repository.PersonajeRepository;
import com.example.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {
    @Autowired
    private PersonajeRepository repository;

    @Override
    public List<PersonajeDTO> findAllByName(String name) throws IOException {
        List<Personaje> personajes = repository.findAll();
        List<Personaje> encontrados = personajes.stream().filter(p -> p.getName().toUpperCase().contains(name.toUpperCase())).toList();
        return encontrados.stream().map(this::mapearaDTO).toList();
    }

    private PersonajeDTO mapearaDTO(Personaje personaje){
        Integer height = null;
        Integer mass = null;
        try{
            height = Integer.parseInt(personaje.getHeight());
        }catch (NumberFormatException e){
            System.out.println("No se pudo parsear el peso: "+ personaje.getHeight());
        }
        try{
            mass = Integer.parseInt(personaje.getMass());
        }catch (NumberFormatException e){
            System.out.println("No se pudo parsear la masa: "+ personaje.getMass());
        }
        PersonajeDTO personajeDTO = new PersonajeDTO(personaje.getName(), height, mass, personaje.getBirthYear(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies());
        return personajeDTO;
    }
}
