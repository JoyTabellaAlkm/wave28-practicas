package com.bootcamp.seguros.repository;

import com.bootcamp.seguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT v FROM Vehiculo v ORDER BY v.anioDeFabricación")
    List<Vehiculo> findAllOrderByAnioDeFabricacion();

    @Query("SELECT v FROM Vehiculo v WHERE v.cantidadDeRuedas > 4 AND v.anioDeFabricación = :year")
    List<Vehiculo> findallFilterByFourRuedasAndAnioDeFabricacion(@Param("year") int year);

    @Query("SELECT s.vehiculoDenunciado, COUNT(*) FROM Siniestro s JOIN s.vehiculoDenunciado WHERE s.perdidaEconomica > 10000")
    List<Vehiculo> findBySiniestroConPerdidaMayorA10000();
}
