package ar.com.mercadolibre.starwars.service.impl;

import ar.com.mercadolibre.starwars.dto.response.PersonajeDTO;
import ar.com.mercadolibre.starwars.repository.IPersonajeRepository;
import ar.com.mercadolibre.starwars.service.IPersonajesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajesService implements IPersonajesService {
    @Autowired
    private IPersonajeRepository personajeRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<PersonajeDTO> findByName(String name) {
        return personajeRepository.findAll()
                .stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase()))
                .map(personaje -> objectMapper.convertValue(personaje, PersonajeDTO.class))
                .toList();
    }
}
