package com.bootcamp.SegurosAutos.repository;

import com.bootcamp.SegurosAutos.entity.Siniestro;
import com.bootcamp.SegurosAutos.repository.projection.VehiculoSiniestroProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

    @Query("SELECT v.patente AS patente, v.marca AS marca, v.modelo AS modelo " +
            "FROM Siniestro s JOIN s.vehiculo v " +
            "WHERE s.perdidaEconomica > 10000")
    List<VehiculoSiniestroProjection> listarVehiculosConSiniestroMayorA10000();

    @Query("SELECT v.patente AS patente, v.marca AS marca, v.modelo AS modelo, SUM(s.perdidaEconomica) AS perdidaTotal " +
            "FROM Siniestro s JOIN s.vehiculo v " +
            "WHERE s.perdidaEconomica > 10000 " +
            "GROUP BY v.patente, v.marca, v.modelo")
    List<VehiculoSiniestroProjection> listarVehiculosConSiniestroMayorA10000ConTotalPerdida();
}
