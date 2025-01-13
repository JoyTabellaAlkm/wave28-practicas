package org.ejercicios.lasperlas.repository;

import org.ejercicios.lasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Integer> {
    List<Joya> findByVentaONoTrue();
}
