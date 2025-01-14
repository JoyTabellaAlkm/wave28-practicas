package com.example.siniestros.repository;

import com.example.siniestros.dto.PatenteMarcaDto;
import com.example.siniestros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo,Integer> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.añoFabricacion")
    List<Object[]> findPatenteMarcaOrderByAñoFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantRuedas > 4 AND v.añoFabricacion = year(current_date())")
    List<String> findPatenteByCantRuedasAndAñoFabricacion();

    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v WHERE v.id IN (SELECT s.vehiculo.id FROM Siniestro s WHERE s.perdidaValor > 10000)")
    List<Object[]> findByPerdidaValorGreaterThan10000();
}
