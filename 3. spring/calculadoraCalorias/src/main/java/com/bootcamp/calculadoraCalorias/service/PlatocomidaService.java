package com.bootcamp.calculadoraCalorias.service;

import com.bootcamp.calculadoraCalorias.dto.response.PlatoComidaResponseDTO;
import com.bootcamp.calculadoraCalorias.model.PlatoComida;

import java.util.List;
import java.util.Locale;

public interface PlatocomidaService {

    PlatoComidaResponseDTO calcularCalorias (PlatoComida platoComida);
    List<PlatoComidaResponseDTO> calcularCaloriasPorPlato(List<PlatoComida> platoComida);
}
