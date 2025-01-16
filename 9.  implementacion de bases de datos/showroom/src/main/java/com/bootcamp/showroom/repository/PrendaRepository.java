package com.bootcamp.showroom.repository;

import com.bootcamp.showroom.entity.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {

    List<Prenda> findAllByCodigo(String codigo);
    List<Prenda> findAllByTalle(String talle);

    List<Prenda> findAllByNombre(String nombre);

}
