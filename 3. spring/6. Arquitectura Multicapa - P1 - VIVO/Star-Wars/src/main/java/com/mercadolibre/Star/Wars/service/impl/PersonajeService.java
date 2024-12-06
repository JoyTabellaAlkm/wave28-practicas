package com.mercadolibre.Star.Wars.service.impl;

import com.mercadolibre.Star.Wars.dto.response.PersonajeResponseDTO;
import com.mercadolibre.Star.Wars.repository.PersonajeRepository;
import com.mercadolibre.Star.Wars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeService implements IPersonajeService {
    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeResponseDTO> findByName(String name) {
        List<PersonajeResponseDTO> personajeResponseDTO = new ArrayList<>();
        try {
            
             personajeRepository.getAllPersonaje().stream()
                     .filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase()))
                     .forEach(personaje -> {
                         personajeResponseDTO.add(new PersonajeResponseDTO(
                                 personaje.getName(),
                                 personaje.getHeight(),
                                 personaje.getMass(),
                                 personaje.getGender(),
                                 personaje.getHomeworld(),
                                 personaje.getSpecies()
                         ));
                     });
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return personajeResponseDTO;
    }
}
