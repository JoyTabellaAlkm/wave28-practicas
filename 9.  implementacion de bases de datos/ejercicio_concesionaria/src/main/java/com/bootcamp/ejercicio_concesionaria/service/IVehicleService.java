package com.bootcamp.ejercicio_concesionaria.service;

import com.bootcamp.ejercicio_concesionaria.dto.VehicleAllDto;
import com.bootcamp.ejercicio_concesionaria.dto.VehicleNoServiceDto;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    public Long addCar(VehicleAllDto vehicleAllDto);
    public List<VehicleNoServiceDto> getAll();
    public VehicleAllDto getById(Long Id);
    public List<VehicleNoServiceDto> getVehicleDates(String since, String to);
    public List<VehicleNoServiceDto> getBetweenPrices(Double since, Double to);
}
