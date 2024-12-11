package com.mercadolibre.ejercicio_global.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.ejercicio_global.dto.VehicleDto;
import com.mercadolibre.ejercicio_global.entity.Vehicle;
import com.mercadolibre.ejercicio_global.exception.NotFoundException;
import com.mercadolibre.ejercicio_global.repository.IVehicleRepository;
import com.mercadolibre.ejercicio_global.repository.VehicleRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

	IVehicleRepository vehicleRepository;

	public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public List<VehicleDto> searchAllVehicles() {
		ObjectMapper mapper = new ObjectMapper();
		List<Vehicle> vehicleList = vehicleRepository.findAll();
		if (vehicleList.isEmpty()) {
			throw new NotFoundException("No se encontró ningún auto en el sistema.");
		}

		return vehicleList.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<VehicleDto> searchVehiclesByColorAndYear(String color, int year) {
		List<VehicleDto> vehicleDtoList = searchAllVehicles();
		List<VehicleDto> filtered = vehicleDtoList.stream()
				.filter(v -> v.getColor().equals(color) && v.getYear() == year)
				.toList();

		if (filtered.isEmpty()) {
			throw new NotFoundException("No se encontraron vehículos con esos criterios.");
		}

		return filtered;
	}
}
