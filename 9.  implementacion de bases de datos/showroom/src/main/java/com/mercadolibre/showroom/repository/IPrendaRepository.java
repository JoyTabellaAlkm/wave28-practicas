package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPrendaRepository extends JpaRepository<Prenda,Integer> {
    List<Prenda> findAllByTalle(String talle);

    List<Prenda> findAllByNombreContainingIgnoreCase(String nombre);
}
