package org.vehiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vehiculos.entity.Vehiculo;

import java.util.List;

@Repository
public interface iVehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("select patente, marca from Vehiculo order by añoFabricacion")
    public List<Object[]> findAllMarcaPatente ();

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y
    //hayan sido fabricados en el corriente año.

    @Query("select patente from Vehiculo where cantidadRuedas > 4 and añoFabricacion = 2025")
    public List<String> findAllMasCuatroRuedas();

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("select v.patente, v.marca, v.modelo from Vehiculo v join v.siniestros s where s.perdidaEconomica > 10000")
    public List<Object[]> findAllVehiculosSiniestros();

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y
    // mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query("select v.patente, v.marca, v.modelo, sum(s.perdidaEconomica) as perdidaTotal from Vehiculo v join v.siniestros s where s.perdidaEconomica > 10000 group by v")
    public List<Object[]> findAllSiniestroPerdidaTotal ();
}
