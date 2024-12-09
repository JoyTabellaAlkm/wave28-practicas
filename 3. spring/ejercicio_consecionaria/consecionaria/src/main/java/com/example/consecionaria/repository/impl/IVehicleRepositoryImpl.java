package com.example.consecionaria.repository.impl;

import com.example.consecionaria.entity.Vehicle;
import com.example.consecionaria.repository.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class IVehicleRepositoryImpl implements IVehicleRepository {
    private final List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public void create(Vehicle entidad) {
        this.vehicles.add(entidad);
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicles;
    }

    @Override
    public List<Vehicle> getByManufacturingDate(LocalDate since, LocalDate to) {
        return getManyByCondition(x -> !x.getManufacturingDate().isBefore(since) && !x.getManufacturingDate().isAfter(to));
    }

    @Override
    public List<Vehicle> getByPrices(double since, double to) {
        return getManyByCondition(x -> x.getPrice() >= since && x.getPrice() <= to);
    }

    @Override
    public Vehicle getById(int id) {
        return vehicles.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    //despues que este metodo sea generico, y heredado de un base
    public List<Vehicle> getManyByCondition(Predicate<Vehicle> predicate) {
        return vehicles.stream().filter(predicate).toList();
    }

}
