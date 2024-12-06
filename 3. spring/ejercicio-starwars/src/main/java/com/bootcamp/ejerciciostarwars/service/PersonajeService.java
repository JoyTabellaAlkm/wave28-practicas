package com.bootcamp.ejerciciostarwars.service;

import com.bootcamp.ejerciciostarwars.dto.PersonajeDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public interface PersonajeService {

    List<PersonajeDTO> findPersonajeByName(String name) throws IOException;

}
