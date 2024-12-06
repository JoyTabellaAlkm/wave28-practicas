package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.PersonajeDTO;
import com.mercadolibre.starwars.model.Personaje;

import java.util.List;

public interface IPersonaje {
    List<PersonajeDTO> buscar(String nombrePesonaje);
}
