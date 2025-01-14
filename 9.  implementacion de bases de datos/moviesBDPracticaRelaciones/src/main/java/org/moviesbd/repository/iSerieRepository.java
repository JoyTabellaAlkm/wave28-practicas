package org.moviesbd.repository;

import org.moviesbd.entity.series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface iSerieRepository extends JpaRepository<series, Integer> {

    @Query("SELECT s FROM series s JOIN s.seasons se GROUP BY s HAVING COUNT(se) > :seasons")
    public List<series> seasonsGraterThan(@Param("seasons") int seasons);
}
