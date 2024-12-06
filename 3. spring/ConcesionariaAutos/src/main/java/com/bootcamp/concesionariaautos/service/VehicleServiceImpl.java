package com.bootcamp.concesionariaautos.service;

import com.bootcamp.concesionariaautos.dto.VehicleDTO;
import com.bootcamp.concesionariaautos.dto.response.VehicleResponseFindAllDTO;
import com.bootcamp.concesionariaautos.model.Vehicle;
import com.bootcamp.concesionariaautos.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public VehicleDTO deleteById(Long id) {
        return null;
    }

    @Override
    public List<VehicleResponseFindAllDTO> findAll() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        return vehicleList.stream().map(v -> objectMapper.convertValue(v, VehicleResponseFindAllDTO.class)).toList();
    }

    @Override
    public VehicleDTO findById(Long id) {
        return null;
    }

    @Override
    public VehicleDTO save(VehicleDTO vehicleDTO) {
        return null;
    }

    @Override
    public VehicleDTO update(VehicleDTO vehicleDTO) {
        return null;
    }
}
