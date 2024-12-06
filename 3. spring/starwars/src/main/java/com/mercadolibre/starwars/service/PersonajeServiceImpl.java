package com.mercadolibre.starwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.PersonajeDTO;
import com.mercadolibre.starwars.model.Personaje;
import com.mercadolibre.starwars.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService{

@Autowired
public IPersonajeRepository persoajeRepository;
@Autowired
private ObjectMapper objectMapper;
    @Override
    public List<PersonajeDTO> getPersonajesByName(String name) throws IOException{
        return persoajeRepository.getAllPersonajes().stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase()))
                .map(personaje -> objectMapper.convertValue(personaje, PersonajeDTO.class))
                .toList();
    }
}
