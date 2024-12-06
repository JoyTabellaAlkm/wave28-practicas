package com.mercadolibre.deportistas.service;

import com.mercadolibre.deportistas.dto.response.DeportistaDTO;

import java.util.List;

public interface IPersonaService {
    public List<DeportistaDTO> devolverDeportistas();
}
