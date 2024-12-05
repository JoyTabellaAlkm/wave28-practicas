package com.mercadolibre.Deportistas.services;

import com.mercadolibre.Deportistas.dto.SportDTO;
import com.mercadolibre.Deportistas.dto.response.SportResponseDTO;

import java.util.List;

public interface ISportService {
    public List<SportDTO> findSports();
    public SportDTO findSportByName(String name);
    public List<SportResponseDTO> findSportsPersons();
}
