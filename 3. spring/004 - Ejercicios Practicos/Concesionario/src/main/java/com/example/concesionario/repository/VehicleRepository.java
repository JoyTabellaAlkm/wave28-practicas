package com.example.concesionario.repository;

import com.example.concesionario.dto.VehicleDTO;
import com.example.concesionario.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    List<Vehicle> vehicleList = new ArrayList<>();

    public Vehicle createVehicle(Vehicle vehicle){
        vehicleList.add(vehicle);
        return  vehicle;
    }

    public List<Vehicle> getAll() {
        return vehicleList;
    }
}
