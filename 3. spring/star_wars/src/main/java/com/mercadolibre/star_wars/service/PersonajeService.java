package com.mercadolibre.star_wars.service;

import com.mercadolibre.star_wars.dto.PersonajeDTO;

import java.io.IOException;
import java.util.List;

public interface PersonajeService {
    public List<PersonajeDTO> findAllByName(String name) throws IOException;
}
