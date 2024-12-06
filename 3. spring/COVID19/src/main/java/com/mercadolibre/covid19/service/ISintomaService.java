package com.mercadolibre.covid19.service;

import com.mercadolibre.covid19.dto.SintomaDTO;

import java.util.List;

public interface ISintomaService {
    public List<SintomaDTO> buscarSintomas();
    public SintomaDTO buscarSintomaPorNombre(String nombreSintoma);
}
