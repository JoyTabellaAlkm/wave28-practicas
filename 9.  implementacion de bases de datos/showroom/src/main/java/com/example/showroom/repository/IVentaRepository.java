package com.example.showroom.repository;

import com.example.showroom.model.Prenda;
import com.example.showroom.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface IVentaRepository extends JpaRepository<Venta, Integer> {
    List<Venta> findByFecha(LocalDateTime fecha);

    @Query("SELECT v.prendas FROM Venta v where v.numero = :numero")
    List<Prenda> findPrendasByNumero(Integer numero);

    List<Venta> findVentasByFechaAfter(LocalDateTime fechaAfter);
}
