package com.seguros_de_autos.reposiroty;

import com.seguros_de_autos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    Vehiculo findByPatente(String patente);

    @Query("SELECT v.patente FROM Vehiculo AS v")
    List<String> getPatente();
}
