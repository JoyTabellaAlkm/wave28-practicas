package org.bootcampmeli.ejercitacionextrasql.repository;

import org.bootcampmeli.ejercitacionextrasql.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrendaRepository extends JpaRepository<Prenda, Long> {

    Prenda findByCodigo(Long codigo);
    List<Prenda> findAllByTalle(String talle);
    List<Prenda> findAllByNombreIsContainingIgnoreCase(String nombre);
}
