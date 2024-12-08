package com.mercadolibre.concesionariaautos.repository;

import com.mercadolibre.concesionariaautos.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    public void create(Vehicle vehicle);
    public List<Vehicle> getAll();
}
