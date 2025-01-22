package com.example.Concesionario.respository;

import com.example.Concesionario.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public List<Vehicle> listAll(){
        return vehicles;
    }

    public Vehicle save(Vehicle vehicle){
        vehicle.setId(vehicles.size()+1);
        vehicles.add(vehicle);
        return vehicle;
    }
}
