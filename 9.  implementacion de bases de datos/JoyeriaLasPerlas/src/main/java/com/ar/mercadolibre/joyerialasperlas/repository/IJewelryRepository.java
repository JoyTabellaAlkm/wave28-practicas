package com.ar.mercadolibre.joyerialasperlas.repository;

import com.ar.mercadolibre.joyerialasperlas.entity.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelryRepository extends JpaRepository<Jewelry, Long> {
}
