package com.bootcamp.ejercicio_starwars.service;

import com.bootcamp.ejercicio_starwars.dto.PersonajeDto;
import com.bootcamp.ejercicio_starwars.mapper.PersonajeMapper;
import com.bootcamp.ejercicio_starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepo;

    @Override
    public List<PersonajeDto> findAllWithName(String name) {
        return personajeRepo.findBy(name).stream()
                .map(PersonajeMapper::toDto).toList();
    }
}
