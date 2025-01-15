package com.mercadolibre.siniestros.repository;

import com.mercadolibre.siniestros.dto.PatenteMarcaDto;
import com.mercadolibre.siniestros.dto.PatenteMarcaModeloDto;
import com.mercadolibre.siniestros.dto.VehiculoSiniestroDto;
import com.mercadolibre.siniestros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Integer> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findPatentes();

    @Query("SELECT new com.mercadolibre.siniestros.dto.PatenteMarcaDto(v.patente, v.marca) FROM Vehiculo v ORDER BY v.añoFabricacion")
    List<PatenteMarcaDto> findPatenteMarcaOrderByAñoFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantRuedas > 4 AND v.añoFabricacion = year(current_date())")
    List<String> findPatenteByCantRuedasAndAñoFabricacion();

    @Query("SELECT new com.mercadolibre.siniestros.dto.PatenteMarcaModeloDto(v.patente, v.marca, v.modelo) FROM Vehiculo v WHERE v.id IN (SELECT s.vehiculo.id FROM Siniestro s WHERE s.perdidaValor > 10000)")
    List<PatenteMarcaModeloDto> findByPerdidaValorGreaterThan10000();

    @Query("SELECT DISTINCT new com.mercadolibre.siniestros.dto.VehiculoSiniestroDto(v,SUM(s.perdidaValor)) FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaValor > 10000 GROUP BY v")
    List<VehiculoSiniestroDto> findVehiculoBySiniestros();
}
