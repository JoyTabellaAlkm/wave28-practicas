package com.example.Starwars.service;

import com.example.Starwars.dto.PersonajeDto;
import com.example.Starwars.entity.Personaje;

import java.io.IOException;
import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDto> findAllByName(String name) throws IOException;
}
