package com.melibootcamp.showroom.repository;

import com.melibootcamp.showroom.entity.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {
    List<Prenda> findByTalle(String talle);

    @Query("SELECT p FROM Prenda p WHERE p.nombre LIKE %:pattern% ")
    List<Prenda> findByPatternOnTitle(@Param("pattern") String pattern);

}
