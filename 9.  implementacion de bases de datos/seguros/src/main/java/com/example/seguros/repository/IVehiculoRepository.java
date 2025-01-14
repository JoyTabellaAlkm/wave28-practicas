package com.example.seguros.repository;

import com.example.seguros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    //Listar las patentes de todos los vehículos registrados.
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("FROM Vehiculo v ORDER BY v.fabricacion ASC")
    List<Vehiculo> findAllOrderedByFabricacion();

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas >= 4 AND YEAR(v.fabricacion) = YEAR(CURRENT_DATE())")
    List<String> filterPatenteByCantidadRuedasGreaterThanFourAndFabricacion();

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.




    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos


}
