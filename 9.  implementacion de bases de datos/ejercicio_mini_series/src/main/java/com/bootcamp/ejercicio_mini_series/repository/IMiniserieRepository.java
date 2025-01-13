package com.bootcamp.ejercicio_mini_series.repository;
import com.bootcamp.ejercicio_mini_series.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {
}
