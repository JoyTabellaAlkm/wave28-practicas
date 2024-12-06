package org.bootcampmeli.ejerciciostarwars.mapper;

import org.bootcampmeli.ejerciciostarwars.dto.PersonajeDTO;
import org.bootcampmeli.ejerciciostarwars.model.Personaje;

public class StarWarsMapper {

    public static PersonajeDTO mapPersonajeDTO(Personaje personaje) {
        return new PersonajeDTO(personaje.getName(),personaje.getHeight(),personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies());
    }
}
