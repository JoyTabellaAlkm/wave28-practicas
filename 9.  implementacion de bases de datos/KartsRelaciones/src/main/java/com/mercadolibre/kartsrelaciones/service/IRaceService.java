package com.mercadolibre.kartsrelaciones.service;

import com.mercadolibre.kartsrelaciones.dto.RaceDTO;

import java.util.List;

public interface IRaceService {

    Long createRace(RaceDTO race);
    List<RaceDTO> getAllRaces();
}
