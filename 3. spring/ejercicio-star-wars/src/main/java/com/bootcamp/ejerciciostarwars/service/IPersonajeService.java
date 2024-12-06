package com.bootcamp.ejerciciostarwars.service;


import com.bootcamp.ejerciciostarwars.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDto> getPersonajesPorNombre(String nombre);
}
