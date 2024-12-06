package com.bootcamp.ejerciciostarwars.service;

import com.bootcamp.ejerciciostarwars.dto.PersonajeDto;
import com.bootcamp.ejerciciostarwars.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements IPersonajeService{
    @Autowired
    IPersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDto> getPersonajesPorNombre(String nombre) {
        return personajeRepository.
                getPersonajes().
                stream().
                filter(p -> p.getName().toLowerCase().contains(nombre.toLowerCase())).
                map(p -> new PersonajeDto(
                        p.getName(),
                        p.getHeight().equalsIgnoreCase("NA") ? -1 : Integer.parseInt(p.getHeight()),
                        p.getMass().equalsIgnoreCase("NA") ? -1 : Integer.parseInt(p.getMass()),
                        p.getGender(),
                        p.getHomeworld(),
                        p.getSpecies())).
                collect(Collectors.toList());
    }
}
