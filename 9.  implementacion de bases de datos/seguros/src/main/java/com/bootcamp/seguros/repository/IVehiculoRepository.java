package com.bootcamp.seguros.repository;

import com.bootcamp.seguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("SELECT v FROM Vehiculo v order by v.anio")
    List<Vehiculo> findAllPatenteAndMarcaOrderByAnio();

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año
    @Query("select v.patente from Vehiculo v where v.ruedas > 4 and v.anio = :anioActual")
    List<String> findPatentesRuedasAndAnio(Integer anioActual);
}
