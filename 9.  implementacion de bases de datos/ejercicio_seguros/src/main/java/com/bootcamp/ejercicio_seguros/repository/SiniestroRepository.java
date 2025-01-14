package com.bootcamp.ejercicio_seguros.repository;

import com.bootcamp.ejercicio_seguros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiniestroRepository extends JpaRepository<Siniestro, Long> {
}
