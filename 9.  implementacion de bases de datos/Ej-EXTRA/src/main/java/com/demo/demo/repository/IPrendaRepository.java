package com.demo.demo.repository;

import com.demo.demo.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPrendaRepository extends JpaRepository<Prenda, String> {
    @Query("SELECT p FROM Prenda p WHERE p.nombre LIKE %:nombre%")
    List<Prenda> findAllByName(@Param("nombre") String name);
}
