package com.mercadolibre.ejercicioseguroautos.repository;

import com.mercadolibre.ejercicioseguroautos.models.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

}
