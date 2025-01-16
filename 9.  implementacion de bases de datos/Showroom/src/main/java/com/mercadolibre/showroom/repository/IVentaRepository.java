package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.entity.Prenda;
import com.mercadolibre.showroom.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByFecha(LocalDate date);
    List<Venta> findByNumero(Long number);

    @Query("SELECT v.prendas FROM Venta v WHERE v.numero = :number")
    List<Prenda> findByClothesNumber(Long number);
}
