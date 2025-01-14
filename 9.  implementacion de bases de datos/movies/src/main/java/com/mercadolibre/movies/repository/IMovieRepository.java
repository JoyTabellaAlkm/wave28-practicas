package com.mercadolibre.movies.repository;

import com.mercadolibre.movies.entity.Actor;
import com.mercadolibre.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT DISTINCT m.id, m.title, m.rating, m.awards, m.length, m.releaseDate  " +
            "FROM Movie m " +
            "Join m.actors a " +
            "WHERE a.rating > ?1")
    List<Object[]> getMoviesByActorRating(Long rating);

    @Query("SELECT DISTINCT m.id, m.title, m.rating, m.awards, m.length, m.releaseDate  " +
            "FROM Movie m " +
            "Join m.genre g " +
            "WHERE g.name like %?1%")
    List<Object[]> getMoviesByGenre(String genre);
}