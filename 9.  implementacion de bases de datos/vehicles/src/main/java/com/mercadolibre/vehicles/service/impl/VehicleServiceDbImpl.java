package com.mercadolibre.vehicles.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mercadolibre.vehicles.dto.ServiceVehicleIdDto;
import com.mercadolibre.vehicles.dto.VehicleAllDto;
import com.mercadolibre.vehicles.dto.VehicleIdDto;
import com.mercadolibre.vehicles.dto.request.CreateVehicleDto;
import com.mercadolibre.vehicles.model.ServiceModel;
import com.mercadolibre.vehicles.model.Vehicle;
import com.mercadolibre.vehicles.repository.IServiceModelRepository;
import com.mercadolibre.vehicles.repository.IVehicleRepository;
import com.mercadolibre.vehicles.service.VehicleService;

@Service
@Primary
@Qualifier("db")
public class VehicleServiceDbImpl implements VehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Autowired
    private IServiceModelRepository serviceModelRepository;

    @Override
    public Vehicle createVehicle(CreateVehicleDto createVehicleDto) {
        ModelMapper mapper = new ModelMapper();
        Vehicle toSave = mapper.map(createVehicleDto, Vehicle.class);
        Vehicle saved = vehicleRepository.save(toSave);

        List<ServiceModel> toSaveServiceModels = createVehicleDto.getServices()
                .stream()
                .map(s -> {
                    ServiceModel sm = mapper.map(s, ServiceModel.class);
                    sm.setVehicle(saved);
                    return sm;
                })
                .toList();
        serviceModelRepository.saveAll(toSaveServiceModels);
        return saved;
    }

    @Override
    public List<VehicleAllDto> listAllVehicles() {
        ModelMapper mapper = new ModelMapper();
        return vehicleRepository.findAll()
                .stream()
                .map(v -> mapper.map(v, VehicleAllDto.class))
                .toList();
    }

    @Override
    public List<VehicleAllDto> listAllVehiclesByManufacturingDate(LocalDate since, LocalDate to) {
        ModelMapper mapper = new ModelMapper();
        return vehicleRepository.findAllByManufacturingDateBetween(since, to)
                .stream()
                .map(v -> mapper.map(v, VehicleAllDto.class))
                .toList();
    }

    @Override
    public List<VehicleAllDto> listAllVehiclesByPrice(int since, int to) {
        ModelMapper mapper = new ModelMapper();
        return vehicleRepository.findAllByPriceBetween(String.valueOf(since), String.valueOf(to))
                .stream()
                .map(v -> mapper.map(v, VehicleAllDto.class))
                .toList();
    }

    @Override
    public VehicleIdDto listVehicleById(int id) {
        ModelMapper mapper = new ModelMapper();
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow();

        VehicleIdDto response = mapper.map(vehicle, VehicleIdDto.class);
        response.setServices(vehicle.getServiceModels()
                .stream()
                .map(s -> mapper.map(s, ServiceVehicleIdDto.class))
                .toList());

        return response;
    }

}
