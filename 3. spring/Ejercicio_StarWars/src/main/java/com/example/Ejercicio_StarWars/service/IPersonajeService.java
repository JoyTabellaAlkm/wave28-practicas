package com.example.Ejercicio_StarWars.service;

import com.example.Ejercicio_StarWars.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDto> listarDto(String toFind);
}
