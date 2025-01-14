package com.mercadolibre.kartsrelaciones.repository;

import com.mercadolibre.kartsrelaciones.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRaceRepository extends JpaRepository<Race, Long> {
}
