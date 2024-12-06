package com.bootcamp.starWars.service;

import com.bootcamp.starWars.dto.PersonajeDTO;

import java.io.IOException;
import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDTO> getPersonajesByName(String name)throws IOException;
}

