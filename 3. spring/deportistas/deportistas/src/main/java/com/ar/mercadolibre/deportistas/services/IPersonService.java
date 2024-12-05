package com.ar.mercadolibre.deportistas.services;

import com.ar.mercadolibre.deportistas.dtos.SportspersonDTO;

import java.util.List;

public interface IPersonService {
    List<SportspersonDTO> findSportsPersons();
}
