package com.bootcamp.seguros.repository;

import com.bootcamp.seguros.dto.VehiculoPatenteMarcaModeloTotalDTO;
import com.bootcamp.seguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    // Listar las patentes de todos los vehículos registrados.
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("SELECT v FROM Vehiculo v ORDER BY v.anioDeFabricación")
    List<Vehiculo> findAllOrderByAnioDeFabricacion();

    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("SELECT v FROM Vehiculo v WHERE v.cantidadDeRuedas = 4 AND v.anioDeFabricación = :year")
    List<Vehiculo> findallFilterByFourRuedasAndAnioDeFabricacion(@Param("year") int year);

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT s.vehiculoDenunciado FROM Siniestro s JOIN s.vehiculoDenunciado WHERE s.perdidaEconomica > 10000")
    List<Vehiculo> findBySiniestroConPerdidaMayorA10000();


    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query("SELECT new com.bootcamp.seguros.dto.VehiculoPatenteMarcaModeloTotalDTO(v.patente, v.marca, v.modelo, s.perdidaEconomica, " +
            "(SELECT SUM(s2.perdidaEconomica) FROM Siniestro s2 WHERE s2.perdidaEconomica > 10000)) " +
            "FROM Siniestro s " +
            "JOIN s.vehiculoDenunciado v " +
            "WHERE s.perdidaEconomica > 10000")
    List<VehiculoPatenteMarcaModeloTotalDTO> findBySiniestroConPerdidaMayorA10000AndPerdidaTotal();




}
