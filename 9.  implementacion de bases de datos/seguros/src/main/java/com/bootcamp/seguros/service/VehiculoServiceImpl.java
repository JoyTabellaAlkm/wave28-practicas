package com.bootcamp.seguros.service;

import com.bootcamp.seguros.dto.request.VehiculoRequestDTO;
import com.bootcamp.seguros.dto.response.VehiculoPatenteYMarcaDTO;
import com.bootcamp.seguros.dto.response.VehiculoResponseDTO;
import com.bootcamp.seguros.entity.Vehiculo;
import com.bootcamp.seguros.repository.IVehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

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

    @Override
    public List<String> findAllPatentes() {
        List<String> listaPatentes = vehiculoRepository.findAllPatentes();
        return listaPatentes;
    }

    @Override
    public List<VehiculoPatenteYMarcaDTO> findAllPatentesAndMarca() {
        List<Vehiculo> listaPatMarca = vehiculoRepository.findAllPatenteAndMarcaOrderByAnio();
        return listaPatMarca.stream()
                .map(vehiculo -> new VehiculoPatenteYMarcaDTO(vehiculo.getPatente(), vehiculo.getMarca()))
                .toList();
    }

    @Override
    public List<String> findPatentesRuedasAndAnio(Integer anioActual) {
        List<String> listaPatenteRuedaAnio = vehiculoRepository.findPatentesRuedasAndAnio(anioActual);
        return listaPatenteRuedaAnio;
    }
}
