package com.mercadolibre.vehicles.service.impl;

import com.mercadolibre.vehicles.dto.ServiceVehicleIdDto;
import com.mercadolibre.vehicles.dto.request.CreateVehicleDto;
import com.mercadolibre.vehicles.dto.VehicleAllDto;
import com.mercadolibre.vehicles.dto.VehicleIdDto;
import com.mercadolibre.vehicles.model.ServiceModel;
import com.mercadolibre.vehicles.model.Vehicle;
import com.mercadolibre.vehicles.repository.VehicleRepository;
import com.mercadolibre.vehicles.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Qualifier("json")
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	private VehicleAllDto convert(Vehicle v) {
		VehicleAllDto vehicleDto = new VehicleAllDto();
		vehicleDto.setId(v.getId());
		vehicleDto.setDoors(v.getDoors());
		vehicleDto.setModel(v.getModel());
		vehicleDto.setCurrency(v.getCurrency());
		vehicleDto.setBrand(v.getBrand());
		vehicleDto.setPrice(v.getPrice());
		vehicleDto.setManufacturingDate(v.getManufacturingDate());
		vehicleDto.setNumberOfKilometers(v.getNumberOfKilometers());
		vehicleDto.setCountOfOwners(v.getCountOfOwners());

		return vehicleDto;
	}

	@Override
	public Vehicle createVehicle(CreateVehicleDto createVehicleDto) {
		Vehicle vehicle = new Vehicle();

		vehicle.setServiceModels(createVehicleDto.getServices().stream().map(s -> {
			ServiceModel serviceModel = new ServiceModel();
			serviceModel.setId(0);
			serviceModel.setDate(s.getDate());
			serviceModel.setDescriptions(s.getDescriptions());
			serviceModel.setKilometers(s.getKilometers());

			return serviceModel;
		}).toList());

		vehicle.setBrand(createVehicleDto.getBrand());
		vehicle.setDoors(createVehicleDto.getDoors());
		vehicle.setCurrency(createVehicleDto.getCurrency());
		vehicle.setCountOfOwners(createVehicleDto.getCountOfOwners());
		vehicle.setManufacturingDate(createVehicleDto.getManufacturingDate());
		vehicle.setNumberOfKilometers(createVehicleDto.getNumberOfKilometers());
		vehicle.setModel(createVehicleDto.getModel());
		vehicle.setPrice(createVehicleDto.getPrice());

		return vehicleRepository.save(vehicle);
	}

	@Override
	public List<VehicleAllDto> listAllVehicles() {
		return vehicleRepository.listAll().stream().map(this::convert).toList();
	}

	@Override
	public List<VehicleAllDto> listAllVehiclesByManufacturingDate(LocalDate since, LocalDate to) {
		return vehicleRepository.listAll().stream().filter(v -> {
			return v.getManufacturingDate().isAfter(since) && v.getManufacturingDate().isBefore(to);
		}).map(this::convert).toList();
	}

	@Override
	public List<VehicleAllDto> listAllVehiclesByPrice(int since, int to) {
		final int too = to == 0 ? Integer.MAX_VALUE : to;
		return vehicleRepository.listAll().stream().filter(v -> {
			int price = Integer.parseInt(v.getPrice());
			return price >= since && price <= too;
		}).map(this::convert).toList();
	}

	@Override
	public VehicleIdDto listVehicleById(int id) {
		Vehicle vehicle = vehicleRepository.listAll().stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
		if (vehicle == null) {
			return null;
		}

		VehicleIdDto vehicleDto = new VehicleIdDto();
		vehicleDto.setId(vehicle.getId());
		vehicleDto.setDoors(vehicle.getDoors());
		vehicleDto.setModel(vehicle.getModel());
		vehicleDto.setCurrency(vehicle.getCurrency());
		vehicleDto.setBrand(vehicle.getBrand());
		vehicleDto.setPrice(vehicle.getPrice());
		vehicleDto.setManufacturingDate(vehicle.getManufacturingDate());
		vehicleDto.setNumberOfKilometers(vehicle.getNumberOfKilometers());
		vehicleDto.setCountOfOwners(vehicle.getCountOfOwners());

		vehicleDto.setServices(vehicle.getServiceModels().stream().map(s -> {
			ServiceVehicleIdDto serviceDto = new ServiceVehicleIdDto();
			serviceDto.setId(s.getId());
			serviceDto.setDate(s.getDate());
			serviceDto.setDescriptions(s.getDescriptions());
			serviceDto.setKilometers(s.getKilometers());

			return serviceDto;
		}).toList());

		return vehicleDto;
	}
}
