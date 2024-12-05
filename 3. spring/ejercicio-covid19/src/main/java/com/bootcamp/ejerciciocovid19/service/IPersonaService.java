package com.bootcamp.ejerciciocovid19.service;

import com.bootcamp.ejerciciocovid19.dto.PersonaRiesgoDto;

import java.util.List;


public interface IPersonaService {
    List<PersonaRiesgoDto> buscarPoblacionDeRiesgo();
}
