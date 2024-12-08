package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.PersonajeDtoResponse;
import com.mercadolibre.starwars.model.Personaje;
import com.mercadolibre.starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonaje{

    @Autowired
    private PersonajeRepository repository;

    @Override
    public List<PersonajeDtoResponse> devolverPersonaje(String name) {
        List<Personaje> personajes = repository.getPersonajes();
        return personajes.stream()
                .filter(personajesFiltrados -> personajesFiltrados.getName().contains(name))
                .map(personaje -> new PersonajeDtoResponse(
                        personaje.getName(),
                        convertToInt(personaje.getHeight()),
                        convertToInt(personaje.getMass()),
                        personaje.getGender(),
                        personaje.getHomeworld(),
                        personaje.getSpecies()
                ))
                .toList();
    }

    private int convertToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("El valor '" + value + "' no puede ser convertido a un entero", e);
        }
    }
}
