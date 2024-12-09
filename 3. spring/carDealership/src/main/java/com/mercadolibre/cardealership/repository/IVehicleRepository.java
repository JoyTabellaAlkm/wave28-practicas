package com.mercadolibre.cardealership.repository;

import com.mercadolibre.cardealership.model.Vehicle;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    String save(Vehicle vehicle);
    List<Vehicle> findAll();
    List<Vehicle> findByManufacturingDate(LocalDate since, LocalDate to);
    List<Vehicle> findByPrice(Double since, Double to);
    Optional<Vehicle> findById(Integer id);
}
