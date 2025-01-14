package com.mercadolibre.kartsrelaciones.repository;

import com.mercadolibre.kartsrelaciones.entity.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPilotRepository extends JpaRepository<Pilot, Long> {
}
