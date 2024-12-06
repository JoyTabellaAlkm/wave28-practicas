package com.example.ejerciciostarwars.service;

import com.example.ejerciciostarwars.dto.PersonajeDto;
import com.example.ejerciciostarwars.model.Personaje;
import com.example.ejerciciostarwars.repositorie.RepositoriePersonajes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {
    List<Personaje> personajes = RepositoriePersonajes.loadDataBase();

    @Override
    public List<PersonajeDto> obtenerPersonaje(String name) {
        List<PersonajeDto> personajesDtos = new ArrayList<>();
        personajes.stream().filter(x -> x.getName().contains(name)).map(this::mapearADto);
        return personajesDtos;
    }

    private PersonajeDto mapearADto(Personaje personaje) {
        PersonajeDto dto = new PersonajeDto();
        dto.setName(personaje.getName());
        dto.setHeight(convertirStringAEntero(personaje.getHeight()));
        dto.setMass(convertirStringAEntero(personaje.getMass()));
        dto.setGender(personaje.getGender());
        dto.setHomeWorld(personaje.getHomeWorld());
        dto.setSpecie(personaje.getSpecie());
        return dto;
    }

    private int convertirStringAEntero(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            return -1;  // Si la altura es null o vacía, devolvemos -1
        }

        if (cadena.equalsIgnoreCase("NA")) {
            return -1;
        }

        try {
            double alturaDecimal = Double.parseDouble(cadena);
            return (int) Math.round(alturaDecimal);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
