package com.example.movies.repository;

import com.example.movies.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {
    @Query("SELECT ser AS cant_temporadas FROM Season sea INNER JOIN  Serie ser ON sea.id = ser.id GROUP BY ser.id HAVING COUNT (sea.id) > :cantTemporadas")
    List<Serie> findBySeasonsCountGreaterThan(@Param("cantTemporadas")int cantTemporadas);
}
