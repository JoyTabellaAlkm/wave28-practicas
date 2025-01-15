package com.mercadolibre.siniestros.repository;

import com.mercadolibre.siniestros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro,Integer> {
}
