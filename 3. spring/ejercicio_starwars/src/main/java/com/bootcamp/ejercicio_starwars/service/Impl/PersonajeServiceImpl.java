package com.bootcamp.ejercicio_starwars.service.Impl;

import com.bootcamp.ejercicio_starwars.dto.PersonajeDto;
import com.bootcamp.ejercicio_starwars.repository.IPersonajeRepository;
import com.bootcamp.ejercicio_starwars.service.IPersonajeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private IPersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDto> getPersonajesByName(String nombre) {
      return personajeRepository.getPersonajesPorNombre(nombre)
              .stream()
              .map(p-> objectMapper.convertValue(p, PersonajeDto.class))
              .toList();
    }

}
