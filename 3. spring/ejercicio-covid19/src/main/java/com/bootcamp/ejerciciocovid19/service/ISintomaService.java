package com.bootcamp.ejerciciocovid19.service;

import com.bootcamp.ejerciciocovid19.dto.SintomaDto;
import com.bootcamp.ejerciciocovid19.model.Sintoma;

import java.util.List;

public interface ISintomaService {
    List<SintomaDto> obtenerSintomas();

    SintomaDto obtenerSintomaPorNombre(String nombre);
}
