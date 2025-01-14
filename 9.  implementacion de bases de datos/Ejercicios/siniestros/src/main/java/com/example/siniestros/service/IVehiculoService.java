package com.example.siniestros.service;

import com.example.siniestros.dto.PatenteMarcaDto;
import com.example.siniestros.dto.PatenteMarcaModeloDto;

import java.util.List;

public interface IVehiculoService {

    List<String> getPatentes();

    List<PatenteMarcaDto> getPatenteMarca();
    List<String> getPatenteByCantRuedasAndAñoFabricacion();

    List<PatenteMarcaModeloDto> findByPerdidaValorGreaterThan10000();
}
