package com.ar.mercadolibre.ejerciciocovid.service;

import com.ar.mercadolibre.ejerciciocovid.DTO.SymptomDTO;

import java.util.List;

public interface ISymptomService {
    List<SymptomDTO> findSymptoms();
    SymptomDTO findSymptomByName(String name);
}
