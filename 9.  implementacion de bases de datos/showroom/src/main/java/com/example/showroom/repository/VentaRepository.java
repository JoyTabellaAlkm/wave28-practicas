package com.example.showroom.repository;

import com.example.showroom.dto.VentaDto;
import com.example.showroom.entity.Prenda;
import com.example.showroom.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta,Long> {
    Venta findByNumero(Long numero);
    void deleteByNumero(Long numero);

    List<Venta> findByFecha(LocalDate fecha);
}
