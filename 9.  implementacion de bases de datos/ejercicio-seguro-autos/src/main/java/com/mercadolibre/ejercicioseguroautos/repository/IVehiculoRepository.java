package com.mercadolibre.ejercicioseguroautos.repository;

import com.mercadolibre.ejercicioseguroautos.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // Obtener las patentes de todos los vehículos registrados.
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> getPatentes();

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("SELECT v FROM Vehiculo v ORDER BY v.fechaFabricacion")
    List<Vehiculo> getVehiculosOrdenadosPorFabricacion();

    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadDeRuedas > 4 AND FUNCTION('YEAR', v.fechaFabricacion) = FUNCTION('YEAR', CURRENT_DATE)")
    List<String> getPatentesConRuedas();

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos
    @Query("SELECT v FROM Vehiculo v INNER JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<Vehiculo> getVehiculosConSiniestroMayorA10000();

}
