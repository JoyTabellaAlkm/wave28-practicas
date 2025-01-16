package com.mercadolibre.siniestros.service;

import java.util.List;

import com.mercadolibre.siniestros.dto.CreateSiniestroDto;
import com.mercadolibre.siniestros.dto.SiniestroDto;

public interface ISiniestroService {

    public List<SiniestroDto> findAllSiniestros();

    public SiniestroDto saveSiniestro(CreateSiniestroDto request);

}
