package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDto> searchPersonajes();
}
