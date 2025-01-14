package com.mercadolibre.kartsrelaciones.repository;

import com.mercadolibre.kartsrelaciones.entity.Kart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKartRepository extends JpaRepository<Kart, Long> {
}
