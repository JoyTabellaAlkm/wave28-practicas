package com.dario.dominguez.practicaconcesionaria.repository;

import com.dario.dominguez.practicaconcesionaria.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
}
