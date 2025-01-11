package com.mercadolibre.miniserie.repository;
import com.mercadolibre.miniserie.entity.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {
}
