package com.bootcamp.vehiculos.service;

import com.bootcamp.vehiculos.dto.PatenteMarcaModeloDto;
import com.bootcamp.vehiculos.dto.PerdidaVehiculoDto;
import com.bootcamp.vehiculos.entity.Vehiculo;

import java.util.List;

public interface VehiculoService {
    Vehiculo crearVehiculo(Vehiculo v);
    List<Vehiculo> getAllVehiculos();
    Vehiculo getById(Long id);
    List<PerdidaVehiculoDto> sumarPerdidas();
    List<PatenteMarcaModeloDto> findMatriculaYMarcaYModeloBySiniestroWithPerdidaGreaterThan10000();
}
