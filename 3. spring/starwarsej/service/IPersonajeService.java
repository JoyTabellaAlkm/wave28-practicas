package com.mercadolibre.starwarsej.service;

import com.mercadolibre.starwarsej.dto.PersonajeDTO;
import com.mercadolibre.starwarsej.model.Personaje;

import java.util.List;

public interface IPersonajeService{
    public List<PersonajeDTO> findByName(String name);
}
