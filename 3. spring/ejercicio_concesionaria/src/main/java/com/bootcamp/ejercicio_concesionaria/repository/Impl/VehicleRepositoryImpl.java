package com.bootcamp.ejercicio_concesionaria.repository.Impl;

import com.bootcamp.ejercicio_concesionaria.entity.Vehicle;
import com.bootcamp.ejercicio_concesionaria.repository.IVehiculoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehiculoRepository {
    private List<Vehicle> vehicleList = new ArrayList<>();

    @Override
    public Long save(Vehicle vehicle) {
        vehicleList.add(vehicle);
        return vehicle.getId();
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleList;
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicleList.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<Vehicle> findBetweenDates(LocalDate since, LocalDate to) {
        return vehicleList.stream().filter(vehicle -> {
            LocalDate manufacturingDate = vehicle.getManufacturingDate();
            return (manufacturingDate.isAfter(since) || manufacturingDate.isEqual(since))
                    &&
                    (manufacturingDate.isBefore(to) || manufacturingDate.isEqual(to));
        }).toList();
    }

    @Override
    public List<Vehicle> findBetweenPrices(Double since, Double to) {
        return vehicleList.stream().filter(vehicle -> {
            Double price = vehicle.getPrice();
            return price >= since && price <= to;
        }).toList();
    }
}
