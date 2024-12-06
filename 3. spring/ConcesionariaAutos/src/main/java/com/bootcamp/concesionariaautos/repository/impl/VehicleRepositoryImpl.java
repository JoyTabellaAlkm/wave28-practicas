package com.bootcamp.concesionariaautos.repository.impl;

import com.bootcamp.concesionariaautos.model.Vehicle;
import com.bootcamp.concesionariaautos.repository.VehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    private static long CONTADOR_VEHICULOS = 0;
    private static final List<Vehicle> vehicleList = new ArrayList<>();

    @Override
    public Vehicle deleteById(Long id) {
        Optional<Vehicle> optionalVehicle = findById(id);
        if(optionalVehicle.isPresent()) {
            vehicleList.remove(optionalVehicle.get());
            return optionalVehicle.get();
        }
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleList;
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return vehicleList.stream().filter(v -> v.getId().equals(id)).findFirst();
    }

    @Override
    public Vehicle save(Vehicle obj) {
        obj.setId(CONTADOR_VEHICULOS);
        CONTADOR_VEHICULOS++;
        vehicleList.add(obj);
        return obj;
    }

    @Override
    public Vehicle update(Vehicle obj) {
        Optional<Vehicle> optionalVehicle = findById(obj.getId());
        if(optionalVehicle.isPresent()) {
            int pos = vehicleList.indexOf(optionalVehicle.get());
            vehicleList.set(pos, obj);
            return obj;
        }
        return null;
    }
}
