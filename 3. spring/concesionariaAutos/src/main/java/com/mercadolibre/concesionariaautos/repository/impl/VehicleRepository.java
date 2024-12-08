package com.mercadolibre.concesionariaautos.repository.impl;

import com.mercadolibre.concesionariaautos.model.Vehicle;
import com.mercadolibre.concesionariaautos.repository.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository {

    private List<Vehicle> vehicles = new ArrayList<>();
    private Integer idCounter = 1;

    @Override
    public void create(Vehicle vehicle) {
        vehicle.setId(idCounter);
        idCounter++;
        this.vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicles;
    }
}
