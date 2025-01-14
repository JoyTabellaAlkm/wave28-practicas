package org.bootcampmeli.empresaseguros.repository;

import org.bootcampmeli.empresaseguros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository <Vehiculo,Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> getPatentes();
}
