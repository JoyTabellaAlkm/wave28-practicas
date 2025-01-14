package com.aseguradora.siniesterManagement.repository;

import com.aseguradora.siniesterManagement.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro,Long> {
}
