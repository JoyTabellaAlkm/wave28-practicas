package com.mercadolibre.cardealership.service.impl;

import com.mercadolibre.cardealership.dto.VehicleDto;
import com.mercadolibre.cardealership.dto.response.VehicleResDto;
import com.mercadolibre.cardealership.model.Vehicle;
import com.mercadolibre.cardealership.repository.IVehicleRepository;
import com.mercadolibre.cardealership.service.IVehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService {

    private final IVehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleService(IVehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String save(VehicleDto vehicle) {
        return vehicleRepository.save(modelMapper.map(vehicle, Vehicle.class));
    }

    @Override
    public List<VehicleResDto> findAll() {
        return vehicleRepository.findAll().stream()
                .map( vehicle -> modelMapper.map( vehicle, VehicleResDto.class))
                .toList();
    }

    @Override
    public List<VehicleDto> findByManufacturingDate(LocalDate since, LocalDate to) {
        return vehicleRepository.findByManufacturingDate(since, to).stream()
                .map( vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .toList();
    }

    @Override
    public List<VehicleDto> findByPrice(Double since, Double to) {
        return vehicleRepository.findByPrice(since, to).stream()
                .map( vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .toList();
    }

    @Override
    public VehicleDto findById(Integer id) {
        return vehicleRepository.findById(id)
                .map( vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .orElse(null);
    }
}
