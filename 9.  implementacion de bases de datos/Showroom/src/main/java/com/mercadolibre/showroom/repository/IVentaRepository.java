package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
}
