package com.mercadolibre.Insurance.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.Insurance.dto.request.VehiculoRequestDTO;
import com.mercadolibre.Insurance.dto.response.VehiculoResponseDTO;
import com.mercadolibre.Insurance.entity.Vehiculo;
import com.mercadolibre.Insurance.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculosService{

    final IVehiculoRepository vehiculoRepository;
    final ModelMapper modelMapper = new ModelMapper();


    public VehiculoServiceImpl(IVehiculoRepository vehiculoRepository, ObjectMapper objectMapper) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public VehiculoResponseDTO createVehiculo(VehiculoRequestDTO vehiculo) {
        Vehiculo vehiculoGuardado = vehiculoRepository.save(modelMapper.map(vehiculo, Vehiculo.class));
        return modelMapper.map(vehiculoGuardado, VehiculoResponseDTO.class);
    }

    @Override
    public List<VehiculoResponseDTO> findAll() {
        List<Vehiculo> listaVehiculos = vehiculoRepository.findAll();
        return listaVehiculos.stream()
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoResponseDTO.class))
                .toList();
    }
}
