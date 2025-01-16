package com.mercadolibre.siniestros.service.impl;

import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.siniestros.dto.CreateVehicleDto;
import com.mercadolibre.siniestros.dto.PatenteMarcaModeloVehicleDto;
import com.mercadolibre.siniestros.dto.PatenteMarcaVehicleDto;
import com.mercadolibre.siniestros.dto.VehiculoDto;
import com.mercadolibre.siniestros.entity.Vehiculo;
import com.mercadolibre.siniestros.repository.IVehiculoRepository;
import com.mercadolibre.siniestros.service.IVehiculoService;

@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<VehiculoDto> findAllVehiculos() {
        return vehiculoRepository.findAll()
                .stream()
                .map(v -> modelMapper.map(v, VehiculoDto.class))
                .toList();
    }

    @Override
    public VehiculoDto saveVehiculo(CreateVehicleDto request) {
        Vehiculo toSave = modelMapper.map(request, Vehiculo.class);
        Vehiculo saved = vehiculoRepository.save(toSave);
        return modelMapper.map(saved, VehiculoDto.class);
    }

    @Override
    public List<String> findAllPatentes() {
        return vehiculoRepository.findAllPatentes();
    }

    @Override
    public List<PatenteMarcaVehicleDto> findAllPatentesAndMarcasOrderByAnioFabricacion() {
        return vehiculoRepository.findAllPatentesAndMarcasOrderByAnioFabricacion();
    }

    @Override
    public List<String> findAllPatentesByCantidadRuedasUpAndAnioFabricacionIs(int cantidadRuedas, int anioFabricacion) {
        return vehiculoRepository.findAllPatentesByCantidadRuedasUpAndAnioFabricacionIs(cantidadRuedas, anioFabricacion);
    }

    @Override
    public Set<PatenteMarcaModeloVehicleDto> findAllPatentesMarcaModeloBySiniestroPerdidaEconomicaUp(double perdidaEconomica) {
        return vehiculoRepository.findAllPatentesMarcaModeloBySiniestroPerdidaEconomicaUp(perdidaEconomica);
    }

    @Override
    public Set<List<?>> findAllPatentesMarcaModeloTotalLossBySiniestroPerdidaEconomicaUp(double perdidaEconomica) {
        return vehiculoRepository.findAllPatentesMarcaModeloTotalLossBySiniestroPerdidaEconomicaUp(perdidaEconomica);
    }

}
