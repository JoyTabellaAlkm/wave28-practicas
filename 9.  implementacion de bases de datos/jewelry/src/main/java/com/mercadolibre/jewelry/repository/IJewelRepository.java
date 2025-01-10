package com.mercadolibre.jewelry.repository;

import com.mercadolibre.jewelry.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel, Long> {
}
