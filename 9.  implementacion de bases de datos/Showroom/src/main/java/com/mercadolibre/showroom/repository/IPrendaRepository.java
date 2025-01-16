package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.entity.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPrendaRepository extends JpaRepository<Prenda, Long> {
    List<Prenda> findByTalle(String size);
    List<Prenda> findByNombreContainingIgnoreCase(String name);
}
