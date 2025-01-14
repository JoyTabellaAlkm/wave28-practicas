package com.mercadolibre.joyeria_las_perlas.repository;

import com.mercadolibre.joyeria_las_perlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya, Long> {
}
