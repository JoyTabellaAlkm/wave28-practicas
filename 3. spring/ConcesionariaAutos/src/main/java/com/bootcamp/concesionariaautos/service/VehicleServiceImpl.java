package com.bootcamp.concesionariaautos.service;

import com.bootcamp.concesionariaautos.dto.ServiceDTO;
import com.bootcamp.concesionariaautos.dto.VehicleDTO;
import com.bootcamp.concesionariaautos.dto.VehicleDTONoServices;
import com.bootcamp.concesionariaautos.model.ServiceEntity;
import com.bootcamp.concesionariaautos.model.Vehicle;
import com.bootcamp.concesionariaautos.repository.ServiceRepository;
import com.bootcamp.concesionariaautos.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ObjectMapper objectMapper;

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
        return null;
    }

    @Override
    public VehicleDTO save(VehicleDTO vehicleDTO) {
        Vehicle newVehicle = objectMapper.convertValue(vehicleDTO, Vehicle.class);
        List<ServiceEntity> vehicleServices = vehicleDTO.getServices()
                .stream()
                .map(s -> objectMapper.convertValue(s, ServiceEntity.class))
                .toList();
        Vehicle finalNewVehicle = vehicleRepository.save(newVehicle);
        vehicleServices = vehicleServices.stream().map(s -> {
            s.setVehicleID(finalNewVehicle.getId());
            return serviceRepository.save(s);
        }).toList();
        vehicleDTO = objectMapper.convertValue(finalNewVehicle, VehicleDTO.class);
        List<ServiceDTO> serviceDTOList = vehicleServices.stream().map(s -> objectMapper.convertValue(s, ServiceDTO.class)).toList();
        vehicleDTO.setServices(serviceDTOList);
        return vehicleDTO;
    }

    @Override
    public VehicleDTO update(VehicleDTO vehicleDTO) {
        return null;
    }
}
