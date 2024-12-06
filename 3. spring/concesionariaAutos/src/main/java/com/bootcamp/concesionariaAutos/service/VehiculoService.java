package com.bootcamp.concesionariaAutos.service;

import com.bootcamp.concesionariaAutos.dto.VehiculoDTO;
import com.bootcamp.concesionariaAutos.dto.VehiculoResponseDTO;
import com.bootcamp.concesionariaAutos.entity.Vehiculo;
import com.bootcamp.concesionariaAutos.repository.VehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    public VehiculoResponseDTO addVehiculo(VehiculoDTO vehiculoDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        Vehiculo vehiculo = objectMapper.convertValue(vehiculoDto, Vehiculo.class);

        VehiculoResponseDTO vehiculoResponse = objectMapper.convertValue(vehiculo, VehiculoResponseDTO.class);

        Optional<VehiculoResponseDTO> optionalVehiculoResponse =  Optional.ofNullable(vehiculoResponse);

        if(vehiculoRepository.saveVehiculo(vehiculo)) {
            return vehiculoResponse;
        }

        return optionalVehiculoResponse.get();
    }

}
