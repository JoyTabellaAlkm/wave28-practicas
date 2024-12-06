package com.mercadolibre.covid19.service;

import com.mercadolibre.covid19.dto.PersonaDTO;


import java.util.List;

public interface IPersonaService {
    public List<PersonaDTO> buscarPersonasDeRiesgo();
}
