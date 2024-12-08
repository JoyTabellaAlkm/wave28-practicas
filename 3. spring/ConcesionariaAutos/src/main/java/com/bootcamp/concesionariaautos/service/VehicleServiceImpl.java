package com.bootcamp.concesionariaautos.service;

import com.bootcamp.concesionariaautos.dto.ServiceDTO;
import com.bootcamp.concesionariaautos.dto.VehicleDTO;
import com.bootcamp.concesionariaautos.dto.VehicleDTONoServices;
import com.bootcamp.concesionariaautos.exception.VehicleNotFoundException;
import com.bootcamp.concesionariaautos.model.ServiceEntity;
import com.bootcamp.concesionariaautos.model.Vehicle;
import com.bootcamp.concesionariaautos.repository.ServiceRepository;
import com.bootcamp.concesionariaautos.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ServiceRepository serviceRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public VehicleServiceImpl(ObjectMapper objectMapper, ServiceRepository serviceRepository, VehicleRepository vehicleRepository) {
        this.objectMapper = objectMapper;
        this.serviceRepository = serviceRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleDTO deleteById(Long id) {
        return null;
    }

    @Override
    public List<VehicleDTONoServices> findAll() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        return vehicleList.stream().map(v -> objectMapper.convertValue(v, VehicleDTONoServices.class)).toList();
    }

    @Override
    public VehicleDTO findById(Long id) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            VehicleDTO vehicleDTO = objectMapper.convertValue(optionalVehicle.get(), VehicleDTO.class);
            List<ServiceEntity> serviceList = serviceRepository.findAll();
            List<ServiceDTO> serviceDTOList = serviceList.stream()
                    .filter(s -> s.getVehicleID().equals(id))
                    .map(s -> objectMapper.convertValue(s, ServiceDTO.class))
                    .toList();
            vehicleDTO.setServices(serviceDTOList);
            return vehicleDTO;
        }
        throw new VehicleNotFoundException("El vehiculo con el id: " + id + " no existe.");
    }

    @Override
    public VehicleDTO save(VehicleDTO vehicleDTO) {
        // Mapping to entities
        Vehicle newVehicle = objectMapper.convertValue(vehicleDTO, Vehicle.class);
        List<ServiceEntity> newVehicleServices = vehicleDTO.getServices()
                .stream()
                .map(s -> objectMapper.convertValue(s, ServiceEntity.class))
                .toList();
        // Persisting the new entities
        Vehicle finalNewVehicle = vehicleRepository.save(newVehicle);
        newVehicleServices = newVehicleServices.stream().map(s -> {
            s.setVehicleID(finalNewVehicle.getId());
            return serviceRepository.save(s);
        }).toList();
        // Mapping back to DTO
        vehicleDTO = objectMapper.convertValue(finalNewVehicle, VehicleDTO.class);
        List<ServiceDTO> serviceDTOList = newVehicleServices.stream().map(s -> objectMapper.convertValue(s, ServiceDTO.class)).toList();
        vehicleDTO.setServices(serviceDTOList);
        return vehicleDTO;
    }

    @Override
    public VehicleDTO update(VehicleDTO vehicleDTO) {
        return null;
    }

    @Override
    public List<VehicleDTONoServices> findAllByManufacturingDate(LocalDate since, LocalDate to) {
        if(since.isAfter(to) || since.isEqual(to)) {
            throw new DateTimeException("La fecha 'since' no puede ser posterior o igual a la fecha 'to'");
        }
        List<Vehicle> vehicleListFilteredByDate = vehicleRepository.findAll()
                .stream()
                .filter(v -> v.getManufacturingDate().isAfter(since) && v.getManufacturingDate().isBefore(to))
                .toList();
        return vehicleListFilteredByDate
                .stream()
                .map(v -> objectMapper.convertValue(v, VehicleDTONoServices.class))
                .toList();
    }

    @Override
    public List<VehicleDTONoServices> findAllByPrice(BigDecimal since, BigDecimal to) {
        if(since.compareTo(to) > 0) {
            throw new IllegalArgumentException("El precio 'since' no puede ser mayor al precio 'to'");
        }
        List<Vehicle> vehicleListFilteredByDate = vehicleRepository.findAll()
                .stream()
                .filter(v -> v.getPrice().compareTo(since) >= 0 && v.getPrice().compareTo(to) <= 0)
                .toList();
        return vehicleListFilteredByDate
                .stream()
                .map(v -> objectMapper.convertValue(v, VehicleDTONoServices.class))
                .toList();
    }
}
