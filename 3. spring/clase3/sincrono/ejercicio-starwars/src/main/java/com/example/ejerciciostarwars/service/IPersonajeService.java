package com.example.ejerciciostarwars.service;

import com.example.ejerciciostarwars.dto.PersonajeDto;
import com.example.ejerciciostarwars.model.Personaje;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDto> obtenerPersonaje(String name);
}
