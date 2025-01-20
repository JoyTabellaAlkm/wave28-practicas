package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.entity.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPrendaRepository extends JpaRepository<Prenda, Long> {
    // buscar por talle
    List<Prenda> findByTalle(String talle);
    // buscar por nombre (LIKE "%:nombre%")
    List<Prenda> findAllByNombreIgnoreCaseContaining(String nombre);
}
