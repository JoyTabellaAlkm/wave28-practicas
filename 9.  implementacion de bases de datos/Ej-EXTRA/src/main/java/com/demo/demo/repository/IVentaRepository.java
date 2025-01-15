package com.demo.demo.repository;

import com.demo.demo.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
    @Query("SELECT v FROM Venta v WHERE v.fecha = :fecha")
    List<Venta> findAllByFullDate(@Param("fecha") LocalDate date);
}
