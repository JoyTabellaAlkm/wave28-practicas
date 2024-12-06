package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;

import java.io.IOException;
import java.util.List;

public interface PersonajeService {
    public List<PersonajeDTO> findAllByName(String name) throws IOException;
}
