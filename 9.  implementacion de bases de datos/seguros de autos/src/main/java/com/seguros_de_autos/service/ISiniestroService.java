package com.seguros_de_autos.service;

import com.seguros_de_autos.DTO.SiniestroDto;
import com.seguros_de_autos.DTO.SiniestroResponseDto;

public interface ISiniestroService {
    public SiniestroResponseDto createSiniestro(SiniestroDto siniestro);
}
