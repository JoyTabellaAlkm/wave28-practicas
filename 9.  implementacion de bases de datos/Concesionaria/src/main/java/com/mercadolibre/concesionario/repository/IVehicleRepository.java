package com.mercadolibre.concesionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mercadolibre.concesionario.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle,String> {
}
