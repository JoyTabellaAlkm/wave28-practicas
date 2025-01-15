package com.mercadolibre.siniestros.service;

import com.mercadolibre.siniestros.dto.PatenteMarcaDto;
import com.mercadolibre.siniestros.dto.PatenteMarcaModeloDto;
import com.mercadolibre.siniestros.dto.VehiculoSiniestroDto;

import java.util.List;

public interface IVehiculoService {

    List<String> getPatentes();

    List<PatenteMarcaDto> getPatenteMarca();
    List<String> getPatenteByCantRuedasAndAñoFabricacion();

    List<PatenteMarcaModeloDto> findByPerdidaValorGreaterThan10000();

    List<VehiculoSiniestroDto> getVehicleBySiniestro();
}
