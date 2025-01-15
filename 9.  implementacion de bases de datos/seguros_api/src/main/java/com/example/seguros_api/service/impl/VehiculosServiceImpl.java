package com.example.seguros_api.service.impl;

import com.example.seguros_api.dto.RequestVehiculoDto;
import com.example.seguros_api.model.Vehiculo;
import com.example.seguros_api.repository.VehiculosRepository;
import com.example.seguros_api.service.IVehiculosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculosServiceImpl implements IVehiculosService {
    @Autowired
    private VehiculosRepository vehiculosRepository;

    @Override
    public Vehiculo create(RequestVehiculoDto requestTestCaseDto) {
        ModelMapper modelMapper = new ModelMapper();
        Vehiculo vehiculo = modelMapper.map(requestTestCaseDto, Vehiculo.class);
        return vehiculosRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> getAll() {
        return vehiculosRepository.findAll();
    }
}
