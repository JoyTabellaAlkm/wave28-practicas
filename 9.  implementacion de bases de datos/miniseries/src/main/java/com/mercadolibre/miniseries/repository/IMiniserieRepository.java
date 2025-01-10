package com.mercadolibre.miniseries.repository;

import com.mercadolibre.miniseries.entity.MiniSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSeries, Long> {
}
