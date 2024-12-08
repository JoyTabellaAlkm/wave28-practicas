package com.bootcamp.personajesStarWars.service.impl;

import com.bootcamp.personajesStarWars.dto.PersonajeDTO;
import com.bootcamp.personajesStarWars.model.Personaje;
import com.bootcamp.personajesStarWars.repository.PersonajeRepository;
import com.bootcamp.personajesStarWars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    PersonajeRepository personajeRepository;
    @Override
    public List<PersonajeDTO> findByName(String name) {
        List<Personaje> personajes = personajeRepository.findByName(name);
        return personajes.stream().map(p ->
                        new PersonajeDTO(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies()))
                .toList();
    }
}
