package com.seguros_de_autos.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seguros_de_autos.DTO.VehiculoDto;
import com.seguros_de_autos.DTO.VehiculoPatentesResponseDto;
import com.seguros_de_autos.DTO.VehiculoResponseDto;
import com.seguros_de_autos.entity.Vehiculo;
import com.seguros_de_autos.reposiroty.IVehiculoRepository;
import com.seguros_de_autos.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoServiceImp implements IVehiculoService {

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    @Autowired
    private ObjectMapper mapper;

    public VehiculoResponseDto createVehiculo(VehiculoDto vehiculo){
        Vehiculo newVehiculo = mapper.convertValue(vehiculo, Vehiculo.class);
        return mapper.convertValue(vehiculoRepository.save(newVehiculo), VehiculoResponseDto.class);
    }

    @Override
    public VehiculoPatentesResponseDto getPatentes() {
        System.out.println(vehiculoRepository.getPatente());
        return new VehiculoPatentesResponseDto(vehiculoRepository.getPatente());
    }
}
