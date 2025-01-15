package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IVentaRepository extends JpaRepository<Venta,Integer> {
    List<Venta> findAllByFecha(LocalDate fecha);
}
