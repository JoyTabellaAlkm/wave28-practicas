package com.dario.dominguez.practicaconcesionaria.repository.impl;

import com.dario.dominguez.practicaconcesionaria.entity.Vehicle;
import com.dario.dominguez.practicaconcesionaria.repository.IVehicleRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository {

    public List<Vehicle> vehiclesList = new ArrayList<>();

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        try {
            vehiclesList.add(vehicle);
        }catch (Exception e){
            return null;
        }
        return vehicle;
    }

    public List<Vehicle> getAllVehicles() {
        return vehiclesList;
    }
}
