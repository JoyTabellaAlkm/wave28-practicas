package com.melibootcamp.empresadeseguros.repository;

import com.melibootcamp.empresadeseguros.dto.PatenteDTO;
import com.melibootcamp.empresadeseguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT V.patente FROM Vehiculo V")
    List<String> getGovernmentPlateFromRegisteredVehicle();

    @Query("FROM Vehiculo V ORDER BY V.anoFabricacion")
    List<Vehiculo> getGovernmentPlateAndBrandFromRegisteredVehicleInOrder();
}
