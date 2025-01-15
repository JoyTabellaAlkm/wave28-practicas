package org.showroommysql.repository;

import org.showroommysql.entity.Ropa;
import org.showroommysql.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

    Venta findByNumero(int numero);

    List<Venta> findByFecha(LocalDate fecha);

    @Query("select r from Venta v join v.ropa r where v.numero = :numero")
    List<Ropa> prendasVenta(int numero);
}
