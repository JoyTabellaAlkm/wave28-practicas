package org.bootcampmeli.ejerciciostarwars.service;

import org.bootcampmeli.ejerciciostarwars.dto.PersonajeDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StarWarsService {


    List<PersonajeDTO> personajesPorNombre(String nombre);
    List<PersonajeDTO> personajes();
}
