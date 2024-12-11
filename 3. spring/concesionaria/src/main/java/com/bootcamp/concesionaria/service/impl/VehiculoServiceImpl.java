package com.bootcamp.concesionaria.service.impl;

import com.bootcamp.concesionaria.dto.VehiculoDto;
import com.bootcamp.concesionaria.model.Vehiculo;
import com.bootcamp.concesionaria.repository.IVehiculoRepository;
import com.bootcamp.concesionaria.repository.impl.VehiculoRepositoryImpl;
import com.bootcamp.concesionaria.service.IVehiculoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    IVehiculoRepository vehiculoRepository;
    ObjectMapper mapper;

    public VehiculoServiceImpl(VehiculoRepositoryImpl vehiculoRepository, ObjectMapper mapper) {
        this.vehiculoRepository = vehiculoRepository;
        this.mapper = mapper;
    }

    @Override
    public String saveVehiculo(VehiculoDto vehiculoDto) {
        Optional<Vehiculo> idExistente = vehiculoRepository.findVehiculoById(vehiculoDto.getId());
        if(idExistente.isPresent()){
            throw new RuntimeException("el vehiculo ya existe");
        }
        Vehiculo vehiculo = mapper.convertValue(vehiculoDto,Vehiculo.class);
        return vehiculoRepository.saveVehiculo(vehiculo);
    }

    @Override
    public List<VehiculoDto> searchAll() {
        List<Vehiculo> vehiculoList = vehiculoRepository.findAll();

        return vehiculoList.stream()
                .map(v-> mapper.convertValue(v,VehiculoDto.class))
                .toList();
    }

    @Override
    public List<VehiculoDto> searchVehiculosByFechaFabricacion(LocalDate since, LocalDate to) {
        List<Vehiculo> vehiculoList = vehiculoRepository.findVehiculosByFechaFabricacion(since,to);
        return vehiculoList.stream()
                .map(v-> mapper.convertValue(v,VehiculoDto.class))
                .toList();
    }

    @Override
    public List<VehiculoDto> searchVehiculosByPrecio(Integer since, Integer to) {
        List<Vehiculo> vehiculoList = vehiculoRepository.findVehiculosByPrecio(since,to);
        return vehiculoList.stream()
                .map(v->mapper.convertValue(v,VehiculoDto.class))
                .toList();
    }

    @Override
    public Optional<Vehiculo> searchVehiculoById(Long id) {
        return vehiculoRepository.findVehiculoById(id);
    }
}
