package com.mercadolibre.las_perlas.repository;

import com.mercadolibre.las_perlas.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILasPerlasRepository extends JpaRepository<Joya, Long> {
}
