package com.mercadolibre.siniestros.service.impl;

import com.mercadolibre.siniestros.dto.PatenteMarcaDto;
import com.mercadolibre.siniestros.dto.PatenteMarcaModeloDto;
import com.mercadolibre.siniestros.dto.VehiculoSiniestroDto;
import com.mercadolibre.siniestros.model.Vehiculo;
import com.mercadolibre.siniestros.repository.IVehiculoRepository;
import com.mercadolibre.siniestros.service.IVehiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService{
    private final ModelMapper mapper = new ModelMapper();
    @Autowired
    IVehiculoRepository vehiculoRepository;
    @Override
    public List<String> getPatentes() {
        return vehiculoRepository.findPatentes();
    }

    @Override
    public List<PatenteMarcaDto> getPatenteMarca() {
        return vehiculoRepository.findPatenteMarcaOrderByAñoFabricacion();
    }

    @Override
    public List<String> getPatenteByCantRuedasAndAñoFabricacion() {
        return vehiculoRepository.findPatenteByCantRuedasAndAñoFabricacion();
    }

    @Override
    public List<PatenteMarcaModeloDto> findByPerdidaValorGreaterThan10000() {
        return vehiculoRepository.findByPerdidaValorGreaterThan10000();
    }

    @Override
    public List<VehiculoSiniestroDto> getVehicleBySiniestro() {
        return vehiculoRepository.findVehiculoBySiniestros();
    }
}
