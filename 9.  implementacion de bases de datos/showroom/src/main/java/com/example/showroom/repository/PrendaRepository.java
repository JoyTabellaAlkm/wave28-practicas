package com.example.showroom.repository;

import com.example.showroom.entity.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrendaRepository extends JpaRepository<Prenda,Long> {
    Prenda findByCodigo(Long codigo);
    Prenda deleteByCodigo(Long codigo);

    @Query("FROM Prenda p WHERE p.talle = :talle")
    List<Prenda> findByTalle(@Param("talle") String talle);
    List<Prenda> findByNombreContainingIgnoreCase(String nombre);

}
