package com.mercadolibre.siniestros.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mercadolibre.siniestros.dto.PatenteMarcaModeloVehicleDto;
import com.mercadolibre.siniestros.dto.PatenteMarcaVehicleDto;
import com.mercadolibre.siniestros.entity.Vehiculo;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    public List<String> findAllPatentes();

    @Query("SELECT new com.mercadolibre.siniestros.dto.PatenteMarcaVehicleDto(v.patente, v.marca) FROM Vehiculo v ORDER BY v.anioFabricacion")
    public List<PatenteMarcaVehicleDto> findAllPatentesAndMarcasOrderByAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas >= ?1 AND year(v.anioFabricacion) = ?2")
    public List<String> findAllPatentesByCantidadRuedasUpAndAnioFabricacionIs(int cantidadRuedas, int anioFabricacion);

    @Query("SELECT new com.mercadolibre.siniestros.dto.PatenteMarcaModeloVehicleDto(v.patente, v.marca, v.modelo) FROM Vehiculo v INNER JOIN Siniestro s ON s.vehiculo = v WHERE s.perdidaEconomica > ?1")
    public Set<PatenteMarcaModeloVehicleDto> findAllPatentesMarcaModeloBySiniestroPerdidaEconomicaUp(double perdidaEconomica);

    @Query("SELECT new com.mercadolibre.siniestros.dto.PatenteMarcaModeloVehicleDto(v.patente, v.marca, v.modelo), SUM(s.perdidaEconomica) FROM Vehiculo v INNER JOIN Siniestro s ON s.vehiculo = v WHERE s.perdidaEconomica > ?1 GROUP BY v.patente, v.marca, v.modelo")
    public Set<List<?>> findAllPatentesMarcaModeloTotalLossBySiniestroPerdidaEconomicaUp(double perdidaEconomica);

}
