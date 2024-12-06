package com.bootcamp.ejercicio_starwars.mapper;

import com.bootcamp.ejercicio_starwars.dto.PersonajeDto;
import com.bootcamp.ejercicio_starwars.model.Personaje;

public class PersonajeMapper {

    private PersonajeMapper(){}

    public static PersonajeDto toDto(Personaje p) {
        return new PersonajeDto(
                p.getName(),
                p.getHeight(),
                p.getMass(),
                p.getGender(),
                p.getHomeworld(),
                p.getSpecies()
        );
    }
}
