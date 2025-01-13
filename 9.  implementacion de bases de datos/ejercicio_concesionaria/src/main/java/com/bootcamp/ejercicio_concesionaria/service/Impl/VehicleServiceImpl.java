package com.bootcamp.ejercicio_concesionaria.service.Impl;

import com.bootcamp.ejercicio_concesionaria.dto.VehicleAllDto;
import com.bootcamp.ejercicio_concesionaria.dto.VehicleNoServiceDto;
import com.bootcamp.ejercicio_concesionaria.entity.Vehicle;
import com.bootcamp.ejercicio_concesionaria.repository.VehiculoRepository;
import com.bootcamp.ejercicio_concesionaria.service.IVehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Long addCar(VehicleAllDto vehicleAllDto) {
        Vehicle vehicle = modelMapper.map(vehicleAllDto, Vehicle.class);
        vehicle.getServices().forEach(service -> service.setVehicle(vehicle));
        return vehiculoRepository.save(vehicle).getId();
    }

    @Override
    public List<VehicleNoServiceDto> getAll() {
        return vehiculoRepository.findAll()
                .stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleNoServiceDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleAllDto getById(Long id) {
        Optional<Vehicle> vehicleOpt = vehiculoRepository.findVehicleWithServicesById(id);
        return vehicleOpt.map(vehicle -> modelMapper.map(vehicle, VehicleAllDto.class)).orElse(null);
    }

    @Override
    public List<VehicleNoServiceDto> getVehicleDates(String since, String to) {
        LocalDate startDate = LocalDate.parse(since);
        LocalDate endDate = LocalDate.parse(to);
        return vehiculoRepository.findBetweenDates(startDate, endDate)
                .stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleNoServiceDto.class))
                .toList();
    }

    @Override
    public List<VehicleNoServiceDto> getBetweenPrices(Double since, Double to) {
        return vehiculoRepository.findByPriceBetween(since, to)
                .stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleNoServiceDto.class))
                .collect(Collectors.toList());
    }
}