package com.bootcamp.concesionaria.service;

import com.bootcamp.concesionaria.dto.VehiculoDTO;
import com.bootcamp.concesionaria.dto.VehiculoUsadoDTO;
import com.bootcamp.concesionaria.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService{
    @Override
    public List<VehiculoDTO> getBetweeenPrice(Double since, Double to) {
        // TODO
        return null;
    }

    @Override
    public VehiculoDTO getById(Long id) throws NotFoundException {
        // TODO
        return null;
    }

    @Override
    public List<VehiculoDTO> getManufacturedBetween(LocalDate since, LocalDate to) {
        // TODO
        return null;
    }

    @Override
    public List<VehiculoUsadoDTO> getUsados() {
        // TODO
        return null;
    }

    @Override
    public void create(VehiculoDTO vehiculo) {
        // TODO
    }
}
