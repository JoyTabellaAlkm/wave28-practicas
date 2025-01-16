package org.example.ejercicio_practico_opcional.repository;

import org.example.ejercicio_practico_opcional.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {
    List<Prenda> findByTalle(String talle);

    @Query("SELECT p FROM Prenda p WHERE LOWER(p.nombre) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Prenda> findByNameContainingIgnoreCase(@Param("name") String name);
}
