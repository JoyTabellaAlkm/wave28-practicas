package com.mercadolibre.Insurance.repository;

import com.mercadolibre.Insurance.dto.response.VehiculoPatenteYMarcaResponseDTO;
import com.mercadolibre.Insurance.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatententes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.ano")
    List<VehiculoPatenteYMarcaResponseDTO> findAllPatenteYMarcasByAno();
}
