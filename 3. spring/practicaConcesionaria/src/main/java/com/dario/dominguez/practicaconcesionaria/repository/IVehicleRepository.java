package com.dario.dominguez.practicaconcesionaria.repository;

import com.dario.dominguez.practicaconcesionaria.entity.Vehicle;

import java.util.List;


public interface IVehicleRepository {
    public Vehicle addVehicle (Vehicle vehicle);
    public List<Vehicle> getAllVehicles();
}
