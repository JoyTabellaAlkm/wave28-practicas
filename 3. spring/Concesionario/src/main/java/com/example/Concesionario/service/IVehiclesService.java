package com.example.Concesionario.service;

import com.example.Concesionario.dto.VehicleAllDto;
import com.example.Concesionario.dto.VehicleIdDto;
import com.example.Concesionario.dto.request.CreateVehicleDto;
import com.example.Concesionario.model.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehiclesService {
    public Vehicle createVehicle(CreateVehicleDto createVehiculoDto);

    public List<VehicleAllDto> listAllVehicles();

    public List<VehicleAllDto> listAllVehiclesByDate(LocalDate since, LocalDate to);

    public List<VehicleAllDto> listAllVehiclesByPrice(int since, int to);

    public VehicleIdDto listAllVehiclesById(int id);
}
