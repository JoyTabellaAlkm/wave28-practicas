package com.melibootcamp.empresadeseguros.repository;

import com.melibootcamp.empresadeseguros.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiniestroRepository extends JpaRepository<Siniestro, Long> {
}
