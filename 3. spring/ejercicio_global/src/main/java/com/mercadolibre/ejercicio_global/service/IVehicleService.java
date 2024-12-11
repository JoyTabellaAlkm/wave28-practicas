package com.mercadolibre.ejercicio_global.service;

import com.mercadolibre.ejercicio_global.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
	List<VehicleDto> searchAllVehicles();
	List<VehicleDto> searchVehiclesByColorAndYear(String color, int year);
}
