package com.bootcamp.vehiculos.repository;

import com.bootcamp.vehiculos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("select v.patente from Vehiculo v")
    List<String> findAllPatentes();

    @Query("select v.patente, v.marca from Vehiculo v order by v.anioFabricacion")
    List<List<String>> findPatenteYMarcaOrderedByAnioFabricacion();

    //@Query("select v.patente from Vehiculo v where v.cantidadRuedas > 4 and year(v.anioFabricacion) = year(current_date)")
    //List<String> findAllPatentesWithMoreThan4RuedasAndFabricadosThisYear();

    @Query("select v.patente, v.marca, v.modelo " +
            "from Vehiculo v " +
            "join v.siniestros s " +
            "where s.perdidaEconomica > 10000")
    List<List<String>> findMatriculaYMarcaYModeloBySiniestroWithPerdidaGreaterThan10000();

    @Query("select v.patente, v.marca, v.modelo, sum(s.perdidaEconomica) " +
            "from Vehiculo v " +
            "join v.siniestros s " +
            "where s.perdidaEconomica > 10000 " +
            "group by v.patente, v.marca, v.modelo")
    List<List<Object>> sumPerdidaBySiniestroWithPerdidaGreaterThan10000();
}
