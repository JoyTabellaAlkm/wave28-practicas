package com.mercadoLibre.MiniSeries.repository;

import com.mercadoLibre.MiniSeries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniserieRepository extends JpaRepository<MiniSerie,Long> {
}
