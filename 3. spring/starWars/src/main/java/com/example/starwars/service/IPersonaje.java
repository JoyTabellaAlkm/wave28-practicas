package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonaje {
    List<PersonajeDTO> buscar(String nombre);
}
