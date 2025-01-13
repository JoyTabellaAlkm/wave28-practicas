package com.mercadolibre.concesionario.service.impl;

import com.mercadolibre.concesionario.dto.VehicleDTO;
import com.mercadolibre.concesionario.model.Vehicle;
import com.mercadolibre.concesionario.repository.IVehicleRepository;
import com.mercadolibre.concesionario.service.ServiceService;
import com.mercadolibre.concesionario.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private IVehicleRepository vehicleRepository;
    @Autowired
    private ServiceService serviceService;

    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        System.out.println();
        Vehicle vehicle = new Vehicle();
        modelMapper.map(vehicleDTO,vehicle);
        vehicleRepository.save(vehicle);
        return vehicleDTO;
    }

    @Override
    public List<VehicleDTO> getAll() {
        return vehicleRepository.findAll().stream()
                .map(vehicle->modelMapper
                        .map(vehicle,VehicleDTO.class))
                .toList();
    }

    @Override
    public List<VehicleDTO> getByDate(LocalDate since, LocalDate to) {
        return vehicleRepository.findAll().stream()
                .filter(
                        v -> v.getManufacturingDate().isAfter(since) && v.getManufacturingDate().isBefore(to))
                .map(vehicle->modelMapper
                        .map(vehicle,VehicleDTO.class)).toList();
    }

    @Override
    public List<VehicleDTO> getByPrice(String since, String to) {
        Integer sinceInt = Integer.parseInt(since);
        Integer toInt = Integer.parseInt(to);
        return vehicleRepository.findAll().stream()
                .filter(v->Integer.parseInt(v.getPrice()) >= sinceInt &&
                        Integer.parseInt(v.getPrice()) <= toInt)
                .map(vehicle->modelMapper
                        .map(vehicle,VehicleDTO.class)).toList();
    }

    @Override
    public VehicleDTO getVehicleById(String id) {
        return modelMapper.map(vehicleRepository.findById(id),VehicleDTO.class);
    }

}
