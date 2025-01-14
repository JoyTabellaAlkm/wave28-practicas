package com.aseguradora.siniesterManagement.repository;

import com.aseguradora.siniesterManagement.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle,Long> {
}
