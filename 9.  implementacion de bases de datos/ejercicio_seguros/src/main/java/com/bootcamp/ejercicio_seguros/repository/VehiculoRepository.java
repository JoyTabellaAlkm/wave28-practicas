package com.bootcamp.ejercicio_seguros.repository;

import com.bootcamp.ejercicio_seguros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v FROM Vehiculo v ORDER BY v.anioFabricacion ASC")
    List<Vehiculo> findAllOrderByAnio();

    @Query("SELECT v FROM Vehiculo v WHERE v.cantidadRuedas >= :cantidadRuedas AND v" +
            ".anioFabricacion = :anio")
    List<Vehiculo> findByCantidadRuedasGreaterThanAndAnio(int cantidadRuedas, int anio);

    @Query("SELECT DISTINCT v FROM Vehiculo v INNER JOIN v.siniestros s WHERE s.perdidaEconomica " +
            ">= :cantidad")
    List<Vehiculo> findVehiculoByPerdidaEconomicaGreaterThan(double cantidad);
}
