package com.mercadolibre.vehicles.service;

import com.mercadolibre.vehicles.dto.request.CreateVehicleDto;
import com.mercadolibre.vehicles.dto.VehicleAllDto;
import com.mercadolibre.vehicles.dto.VehicleIdDto;
import com.mercadolibre.vehicles.model.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface VehicleService {

	public Vehicle createVehicle(CreateVehicleDto createVehicleDto);

	public List<VehicleAllDto> listAllVehicles();

	public List<VehicleAllDto> listAllVehiclesByManufacturingDate(LocalDate since, LocalDate to);

	public List<VehicleAllDto> listAllVehiclesByPrice(int since, int to);

	public VehicleIdDto listVehicleById(int id);

}
