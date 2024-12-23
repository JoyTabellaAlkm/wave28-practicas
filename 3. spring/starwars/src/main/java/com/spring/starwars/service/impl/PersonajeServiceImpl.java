package com.spring.starwars.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.starwars.dto.PersonajeDTO;
import com.spring.starwars.repository.PersonajeRepository;
import com.spring.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDTO> findByName(String name) {
        ObjectMapper mapper = new ObjectMapper();
        return personajeRepository.findBy(name).stream()
                .map(p->mapper.convertValue(p,PersonajeDTO.class))
                .toList();
    }
}
