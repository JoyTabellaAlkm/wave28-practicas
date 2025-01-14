package com.mercadolibre.movies.repository;

import com.mercadolibre.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Integer> {
    @Query("SELECT DISTINCT mov FROM Movie mov JOIN mov.actorMovies am JOIN am.actor a WHERE a.rating > :rating")
    List<Movie> findMoviesByActorRating(@Param("rating")BigDecimal rating);

    @Query("SELECT mov FROM Movie mov JOIN mov.genre gen WHERE gen.name = :genero")
    List<Movie> findMoviesByGenre(@Param("genero")String genero);
}
