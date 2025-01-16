package org.example.ejercicio_practico_opcional.repository;

import org.example.ejercicio_practico_opcional.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByFecha(Date fecha);
}
