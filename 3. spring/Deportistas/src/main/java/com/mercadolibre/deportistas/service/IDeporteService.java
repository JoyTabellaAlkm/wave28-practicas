package com.mercadolibre.deportistas.service;

import com.mercadolibre.deportistas.dto.request.DeporteDTO;

import java.util.List;

public interface IDeporteService {
    List<DeporteDTO> buscarDeportes();
    String buscarDeportePorNombre(String name);
}
