package com.example.MiniSeries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<com.example.MiniSeries.model.MiniSerie, Integer> {
}
