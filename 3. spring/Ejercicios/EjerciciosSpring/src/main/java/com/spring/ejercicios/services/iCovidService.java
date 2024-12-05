package com.spring.ejercicios.services;

import com.spring.ejercicios.dto.personaDTO;
import com.spring.ejercicios.models.Sintoma;

import java.util.List;

public interface iCovidService {

    public String existeSintoma (String name);

    public List<Sintoma> todosSintomas();

    public List<personaDTO> personasRiesgo();
}
