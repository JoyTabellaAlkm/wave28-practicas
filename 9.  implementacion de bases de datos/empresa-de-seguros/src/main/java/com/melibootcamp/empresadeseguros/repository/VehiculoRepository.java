package com.melibootcamp.empresadeseguros.repository;

import com.melibootcamp.empresadeseguros.dto.MarcaMatriculaModeloDTO;
import com.melibootcamp.empresadeseguros.dto.VehiculoInfoDTO;
import com.melibootcamp.empresadeseguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT new com.melibootcamp.empresadeseguros.dto.VehiculoInfoDTO(v.patente, v.marca) " +
            "FROM Vehiculo v ORDER BY v.anoFabricacion ASC")
    List<VehiculoInfoDTO> findPatenteAndVehiculoOrderAnioFabricacion();

    @Query("SELECT DISTINCT new com.melibootcamp.empresadeseguros.dto.MarcaMatriculaModeloDTO(v.patente, v.marca, v.modelo) " +
            "FROM Vehiculo v JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > 10000")
    List<MarcaMatriculaModeloDTO> findAllMarcaMatriculaModeloWherePerdidaMayorA10000();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas >= 4 AND YEAR(v.anoFabricacion) = YEAR(CURRENT_DATE)")
    List<String> findPatentesWhereMasDe4RuedasAndFabricadosEsteAño();
}
