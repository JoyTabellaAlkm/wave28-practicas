package com.bootcamp.primerjpa.repository;

import com.bootcamp.primerjpa.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniserieRepository extends JpaRepository<MiniSerie, Long> {
}
