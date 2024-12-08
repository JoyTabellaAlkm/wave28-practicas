package com.bootcamp.personajesStarWars.service;

import com.bootcamp.personajesStarWars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService{
    List<PersonajeDTO> findByName(String name);
}
