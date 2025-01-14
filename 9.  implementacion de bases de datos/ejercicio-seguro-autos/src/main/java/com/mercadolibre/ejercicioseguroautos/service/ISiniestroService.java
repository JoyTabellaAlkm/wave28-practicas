package com.mercadolibre.ejercicioseguroautos.service;

import com.mercadolibre.ejercicioseguroautos.dto.SiniestroDTO;
import com.mercadolibre.ejercicioseguroautos.dto.VehiculoDTO;

import java.util.List;

public interface ISiniestroService {

    List<SiniestroDTO> getAllSiniestros();
    SiniestroDTO saveSiniestro(SiniestroDTO siniestroDTO);
}
