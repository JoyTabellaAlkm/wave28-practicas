package com.mercadolibre.starwarsej.service;

import com.mercadolibre.starwarsej.dto.PersonajeDTO;
import com.mercadolibre.starwarsej.model.Personaje;
import com.mercadolibre.starwarsej.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService implements IPersonajeService{

    @Autowired
    IPersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDTO> findByName(String name) {
        List<Personaje> personajeList = personajeRepository.loadPersonajes();

        List<PersonajeDTO> personajesFiltrados = personajeList.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .map(this::convertToDto)
                .toList();

        return personajesFiltrados;
    }

    public PersonajeDTO convertToDto(Personaje p) {
        PersonajeDTO pDTo = new PersonajeDTO();
        pDTo.setName(p.getName());

        Integer height = null;
        try {
            height = Integer.valueOf(p.getHeight());
        } catch (NumberFormatException ignored) {}
        pDTo.setHeight(height);

        Integer mass = null;
        try {
            mass = Integer.valueOf(p.getMass());
        } catch (NumberFormatException ignored) {}
        pDTo.setMass(mass);

        pDTo.setGender(p.getGender());
        pDTo.setHomeworld(p.getHomeworld());
        pDTo.setSpecies(p.getSpecies());
        return pDTo;
    }
}
