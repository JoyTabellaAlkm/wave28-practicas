package com.bootcamp.concesionaria.service;

import com.bootcamp.concesionaria.dto.VehiculoDto;
import com.bootcamp.concesionaria.model.Vehiculo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IVehiculoService {
    String saveVehiculo(VehiculoDto vehiculoDto);

    List<VehiculoDto> searchAll();

    List<VehiculoDto> searchVehiculosByFechaFabricacion(LocalDate since, LocalDate to);

    List<VehiculoDto> searchVehiculosByPrecio(Integer since, Integer to);

    Optional<Vehiculo> searchVehiculoById(Long id);

}
