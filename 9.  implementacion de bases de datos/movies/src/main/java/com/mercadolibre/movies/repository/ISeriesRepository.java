package com.mercadolibre.movies.repository;

import com.mercadolibre.movies.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeriesRepository extends JpaRepository<Series,Integer> {
    @Query("SELECT se.title FROM Series se JOIN se.seasons ss GROUP BY se.title HAVING COUNT(*) > :temporadas")
    List<String> findSeriesBySeasonsContaining(@Param("temporadas") int temporadas);
}
