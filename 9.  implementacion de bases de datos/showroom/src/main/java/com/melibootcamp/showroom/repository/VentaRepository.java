package com.melibootcamp.showroom.repository;

import com.melibootcamp.showroom.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
