package com.mercadolibre.siniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadolibre.siniestros.entity.Siniestro;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

}
