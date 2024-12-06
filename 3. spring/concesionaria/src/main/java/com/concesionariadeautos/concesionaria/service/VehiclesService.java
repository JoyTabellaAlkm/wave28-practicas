package com.concesionariadeautos.concesionaria.service;

import com.concesionariadeautos.concesionaria.dto.VehiclesDTO;
import com.concesionariadeautos.concesionaria.model.Vehicles;
import com.concesionariadeautos.concesionaria.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclesService {

    @Autowired
    private VehiclesRepository vehiclesRepository;

    public List<VehiclesDTO> getVehicles() {
        //Mapeo
        List<Vehicles> vehicles = vehiclesRepository.getVehicles();

        return vehicles.stream().map(v -> new VehiclesDTO(v.getBrand(),v.getModel(),v.getManufacturingDate().toString(),v.getNumberOfKilometers().toString(),v.getDoors().toString(),v.getPrice().toString(),v.getCurrency(),v.getServices(),v.getCountOfOwners().toString())).toList();
    }
}
