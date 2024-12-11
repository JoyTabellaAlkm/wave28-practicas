package com.bootcamp.miniseriesjpa.repository;

import com.bootcamp.miniseriesjpa.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
