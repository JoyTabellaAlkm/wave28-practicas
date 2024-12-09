package com.dario.dominguez.practicaconcesionaria.service;

import com.dario.dominguez.practicaconcesionaria.dto.VehicleDto;
import com.dario.dominguez.practicaconcesionaria.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    public Vehicle addVehicle (VehicleDto vehicleDto);
    public List<VehicleDto> getAllVehicles();
    public List<VehicleDto> getSinceTo(String since, String to);
}
