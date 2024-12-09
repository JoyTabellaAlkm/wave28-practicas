package com.bootcamp.ejercicio_starwars.service;


import com.bootcamp.ejercicio_starwars.dto.PersonajeDto;
import java.util.List;

public interface IPersonajeService {

    List<PersonajeDto> getPersonajesByName(String nombre);



}
