package com.bootcamp.miniSeries.repository;

import com.bootcamp.miniSeries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {
}
