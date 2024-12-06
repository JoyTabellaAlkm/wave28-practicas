package com.example.ejerciciocovid.service;

import com.example.ejerciciocovid.dto.PersonaDto;
import com.example.ejerciciocovid.dto.SintomaDto;
import com.example.ejerciciocovid.model.Sintoma;

import java.util.List;

public interface ISintomaService {
    public List<Sintoma> obtenerSintomas();
    public SintomaDto obtenerSintoma(String nombre);
    public List<PersonaDto> obtenerPersonasDeRiesgo();
}
