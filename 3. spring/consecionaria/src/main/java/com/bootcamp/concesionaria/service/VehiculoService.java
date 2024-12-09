package com.bootcamp.concesionaria.service;

import com.bootcamp.concesionaria.dto.VehiculoDTO;
import com.bootcamp.concesionaria.dto.VehiculoUsadoDTO;
import com.bootcamp.concesionaria.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface VehiculoService {
    List<VehiculoDTO> getBetweeenPrice(Double since, Double to);
    VehiculoDTO getById(Long id) throws NotFoundException;

    List<VehiculoDTO> getManufacturedBetween(LocalDate since, LocalDate to);

    List<VehiculoUsadoDTO> getUsados();

    void create(VehiculoDTO vehiculo);
}
