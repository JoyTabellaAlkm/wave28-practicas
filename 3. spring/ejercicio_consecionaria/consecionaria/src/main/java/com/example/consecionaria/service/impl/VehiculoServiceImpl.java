package com.example.consecionaria.service.impl;

import com.example.consecionaria.dto.VehiculoDTO;
import com.example.consecionaria.entity.Vehiculo;
import com.example.consecionaria.repository.IVehiculoRepository;
import com.example.consecionaria.service.IVehiculoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public VehiculoDTO crearVehiculo(VehiculoDTO request) {
        Vehiculo nuevoVehiculo = objectMapper.convertValue(request, Vehiculo.class);
//        Vehiculo nuevoVehiculo = new Vehiculo(request.getBrand(),
//                request.getModel(),
//                request.getManufacturingDate(),
//                request.getNumberOfKilometers(),
//                request.getDoors(),
//                request.getPrice(),
//                request.getCurrency(),
//                request.getServices(),
//                request.getCountOfOwners());
        vehiculoRepository.crear(nuevoVehiculo);
        return request;
    }
}
