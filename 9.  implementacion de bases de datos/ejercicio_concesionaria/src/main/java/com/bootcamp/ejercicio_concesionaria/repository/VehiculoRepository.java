package com.bootcamp.ejercicio_concesionaria.repository;

import com.bootcamp.ejercicio_concesionaria.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v LEFT JOIN FETCH v.services WHERE v.id = :id")
    Optional<Vehicle> findVehicleWithServicesById(@Param("id") Long id);

    List<Vehicle> findByPriceBetween(Double minPrice, Double maxPrice);

    @Query("SELECT v FROM Vehicle v WHERE v.manufacturingDate BETWEEN :startDate AND :endDate")
    List<Vehicle> findBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
