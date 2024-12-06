package com.spring.ejercicios.services;

import com.spring.ejercicios.dto.PersonaCovidDTO;
import com.spring.ejercicios.models.Sintoma;

import java.util.List;

public interface iCovidService {

    public String existeSintoma (String name);

    public List<Sintoma> todosSintomas();

    public List<PersonaCovidDTO> personasRiesgo();
}
