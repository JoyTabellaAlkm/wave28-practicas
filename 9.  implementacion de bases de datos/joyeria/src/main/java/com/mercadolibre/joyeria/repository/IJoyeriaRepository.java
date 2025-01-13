package com.mercadolibre.joyeria.repository;

import com.mercadolibre.joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyeriaRepository extends JpaRepository<Joya,Long> {
}
