package com.mercadolibre.deportistas.service;

import com.mercadolibre.deportistas.dto.DeporteDTO;
import com.mercadolibre.deportistas.dto.PersonaDeporteDTO;

import java.util.List;

public interface IDeporteService {
    public List<DeporteDTO> getSports();
    public Integer getSportByName(String name);
    public List<PersonaDeporteDTO> getSportsPersons();
}
