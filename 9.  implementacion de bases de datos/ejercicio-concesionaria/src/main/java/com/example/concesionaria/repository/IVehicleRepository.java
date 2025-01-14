package com.example.concesionaria.repository;

import com.example.concesionaria.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle, String> { }
