package com.ar.mercadolibre.deportistas.services;

import com.ar.mercadolibre.deportistas.dtos.SportDTO;

import java.util.List;

public interface ISportService {
    List<SportDTO> findSports();
    String getLevelBySportName(String name);
}
