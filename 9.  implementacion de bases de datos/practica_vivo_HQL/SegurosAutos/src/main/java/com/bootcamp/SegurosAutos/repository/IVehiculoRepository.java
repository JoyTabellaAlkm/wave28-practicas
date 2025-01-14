package com.bootcamp.SegurosAutos.repository;

import com.bootcamp.SegurosAutos.entity.Vehiculo;
import com.bootcamp.SegurosAutos.repository.projection.PatenteMarcaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> obtenerPatentes();

    @Query("SELECT v.patente AS patente, v.marca AS marca FROM Vehiculo v ORDER BY v.fabricacion")
    List<PatenteMarcaProjection> obtenerPatentesYMarcasOrdenadosPorFabricacion();

    @Query("SELECT v.patente AS patente, v.marca AS marca FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.fabricacion = :year")
    List<PatenteMarcaProjection> obtenerPatentesMarcasDeAutosMasDeCuatroRuedasFabricadosEsteAnio(int year);
}
