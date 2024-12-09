package com.bootcamp.ejercicio_concesionaria.service.Impl;

import com.bootcamp.ejercicio_concesionaria.dto.VehicleAllDto;
import com.bootcamp.ejercicio_concesionaria.dto.VehicleNoServiceDto;
import com.bootcamp.ejercicio_concesionaria.entity.Vehicle;
import com.bootcamp.ejercicio_concesionaria.repository.IVehiculoRepository;
import com.bootcamp.ejercicio_concesionaria.service.IVehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {
    @Autowired
    private IVehiculoRepository vehiculoRepository;
    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Long addCar(VehicleAllDto vehicleAllDto) {
        Vehicle vehicle = objectMapper.convertValue(vehicleAllDto, Vehicle.class);
        return vehiculoRepository.save(vehicle);
    }

    @Override
    public List<VehicleNoServiceDto> getAll() {
        return vehiculoRepository.findAll()
                .stream()
                .map(s -> objectMapper.convertValue(s, VehicleNoServiceDto.class))
                .toList();
    }

    @Override
    public VehicleAllDto getById(Long id) {
        return objectMapper.convertValue(vehiculoRepository.findById(id), VehicleAllDto.class);
    }


    @Override
    public List<VehicleNoServiceDto> getVehicleDates(String since, String to) {
        LocalDate sinceDate = objectMapper.convertValue(since, LocalDate.class);
        LocalDate toDate = objectMapper.convertValue(to, LocalDate.class);
        return vehiculoRepository.findBetweenDates(sinceDate, toDate)
                .stream()
                .map(s -> objectMapper.convertValue(s, VehicleNoServiceDto.class))
                .toList();
    }

    @Override
    public List<VehicleNoServiceDto> getBetweenPrices(Double since, Double to) {
        return vehiculoRepository.findBetweenPrices(since, to)
                .stream()
                .map(s -> objectMapper.convertValue(s, VehicleNoServiceDto.class))
                .toList();
    }
}
