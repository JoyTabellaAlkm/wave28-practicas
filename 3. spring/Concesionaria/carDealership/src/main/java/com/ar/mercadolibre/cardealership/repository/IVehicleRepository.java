package com.ar.mercadolibre.cardealership.repository;

import com.ar.mercadolibre.cardealership.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> getAll();
    List<Vehicle> getByManufacturingDateRange(String from, String to);
    List<Vehicle> getByPriceRange(String from, String to);
    Vehicle getById(Long id);
    Vehicle create(Vehicle vehicle);
}
