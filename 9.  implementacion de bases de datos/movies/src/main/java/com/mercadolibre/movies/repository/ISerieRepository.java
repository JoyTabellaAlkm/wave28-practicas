package com.mercadolibre.movies.repository;

import com.mercadolibre.movies.entity.Movie;
import com.mercadolibre.movies.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ISerieRepository extends JpaRepository<Serie, Long> {

    @Query("SELECT s.id, s.title, s.releaseDate, s.endDate  " +
            "FROM Serie s " +
            "Join s.seasons se " +
            "GROUP BY s.id, s.title, s.releaseDate, s.endDate " +
            "HAVING COUNT(s.id) > :amount")
    List<Object[]> getSeriesBySeasonAmount(Integer amount);

    @Query("SELECT ep.id, ep.title, ep.number ,ep.releaseDate, ep.endDate  " +
            "FROM Serie s " +
            "Join s.seasons se " +
            "Join se.episodes ep " +
            "Join ep.actors a " +
            "WHERE a.firstName like %:actorName%")
    List<Object[]> getEpisodesByActor(@Param("actorName") String actorName);
}