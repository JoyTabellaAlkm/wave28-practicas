package com.melibootcamp.empresadeseguros.repository;

import com.melibootcamp.empresadeseguros.dto.PatenteDTO;
import com.melibootcamp.empresadeseguros.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiniestroRepository extends JpaRepository<Siniestro, Long> {
}
