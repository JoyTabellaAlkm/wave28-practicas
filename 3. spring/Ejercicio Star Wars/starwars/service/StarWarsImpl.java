package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.entity.Personaje;
import com.example.starwars.repository.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsImpl implements IStarWarsService {

    @Autowired
    private StarWarsRepository starWarsRepository;

    @Override
    public List<PersonajeDTO> getPersonajesByName(String nombre) {
      return starWarsRepository.getPersonajesPorNombre(nombre).stream().map(p->new PersonajeDTO(p.getName(),p.getHeight(),p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies())).toList();
    }

}
