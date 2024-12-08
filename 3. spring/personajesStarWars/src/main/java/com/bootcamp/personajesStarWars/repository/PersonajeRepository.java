package com.bootcamp.personajesStarWars.repository;

import com.bootcamp.personajesStarWars.dto.PersonajeDTO;
import com.bootcamp.personajesStarWars.model.Personaje;

import java.util.List;

public interface PersonajeRepository{

    List<Personaje> findByName(String name);
}
