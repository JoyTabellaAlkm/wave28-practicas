package com.example.ejerciciostarwars.service;

import com.example.ejerciciostarwars.dto.PersonajeDto;
import com.example.ejerciciostarwars.exceptions.NotFoundException;
import com.example.ejerciciostarwars.model.Personaje;
import com.example.ejerciciostarwars.repositorie.RepositoriePersonajes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {
    List<Personaje> personajes = RepositoriePersonajes.loadDataBase();

    @Override
    public List<PersonajeDto> obtenerPersonaje(String name){
        List<PersonajeDto> personajesDto = personajes.stream()
                .filter(x->x.getName().toUpperCase().contains(name.toUpperCase()))
                .map(this::mapearADto).toList();
        if (personajesDto.size()<=0){
            throw new NotFoundException("No hay ningun personaje de nombre " + name);
        }
        return personajesDto;
    }

    private PersonajeDto mapearADto(Personaje personaje) {
        PersonajeDto dto = new PersonajeDto();
        dto.setName(personaje.getName());
        dto.setHeight(convertirStringAEntero(personaje.getHeight()));
        dto.setMass(convertirStringAEntero(personaje.getMass()));
        dto.setGender(personaje.getGender());
        dto.setHomeWorld(personaje.getHomeworld());
        dto.setSpecie(personaje.getSpecies());
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
