package com.example.segurosdeautos.service.impl;

import com.example.segurosdeautos.dto.request.VehiculoRequestDto;
import com.example.segurosdeautos.dto.response.VehiculoResponseDto;
import com.example.segurosdeautos.model.Vehiculo;
import com.example.segurosdeautos.repository.IVehiculoRepository;
import com.example.segurosdeautos.service.IVehiculoService;
import com.example.segurosdeautos.util.Utility;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public VehiculoResponseDto crearVehiculo(VehiculoRequestDto vehiculo) {

        Vehiculo vehiculoEntity = Utility.getModelMapper()
                .map(vehiculo, Vehiculo.class);

        return Utility.getModelMapper()
                .map(vehiculoRepository.save(vehiculoEntity), VehiculoResponseDto.class);
    }

    @Override
    public List<VehiculoResponseDto> obtenerTodosLosVehiculos() {
        List<Vehiculo> vehiculoList = vehiculoRepository.findAll();

        return vehiculoList.stream()
                .map(vehiculo -> Utility.getModelMapper()
                        .map(vehiculo, VehiculoResponseDto.class))
                .toList();
    }

    @Override
    public VehiculoResponseDto obtenerVehiculoPorId(Long id) {
        Optional<Vehiculo> vehiculoEncontrado = vehiculoRepository.findById(id);
        return vehiculoEncontrado.map(vehiculo -> Utility.getModelMapper()
                .map(vehiculo, VehiculoResponseDto.class)).orElse(null);
    }
}
