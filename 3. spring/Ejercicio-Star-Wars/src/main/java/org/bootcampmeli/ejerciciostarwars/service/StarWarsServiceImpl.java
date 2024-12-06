package org.bootcampmeli.ejerciciostarwars.service;


import org.bootcampmeli.ejerciciostarwars.dto.PersonajeDTO;
import org.bootcampmeli.ejerciciostarwars.mapper.StarWarsMapper;
import org.bootcampmeli.ejerciciostarwars.model.Personaje;
import org.bootcampmeli.ejerciciostarwars.repository.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsServiceImpl implements StarWarsService {

    @Autowired
    StarWarsRepository starWarsRepository;



    @Override
    public List<PersonajeDTO> personajesPorNombre(String nombre) {

        List<Personaje> personajes = starWarsRepository.getByName(nombre);

        return personajes.stream()
                .map(StarWarsMapper::mapPersonajeDTO)
                .toList();



    }

    @Override
    public List<PersonajeDTO> personajes() {
        List<Personaje> personajes = starWarsRepository.getPersonajeList();
        return personajes.stream()
                .map(StarWarsMapper::mapPersonajeDTO)
                .toList();
    }


}
