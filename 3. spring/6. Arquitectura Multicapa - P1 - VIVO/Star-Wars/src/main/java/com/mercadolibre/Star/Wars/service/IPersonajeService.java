package com.mercadolibre.Star.Wars.service;

import com.mercadolibre.Star.Wars.dto.PersonajeDTO;
import com.mercadolibre.Star.Wars.dto.response.PersonajeResponseDTO;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeResponseDTO> findByName(String name);
}
