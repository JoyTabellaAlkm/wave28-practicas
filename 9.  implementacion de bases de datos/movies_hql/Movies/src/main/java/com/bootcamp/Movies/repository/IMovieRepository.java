package com.bootcamp.Movies.repository;

import com.bootcamp.Movies.entity.Movie;
import com.bootcamp.Movies.repository.projection.ActorsProjection;
import com.bootcamp.Movies.repository.projection.MovieRatingProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT a.firstName AS firstName, a.lastName AS lastName, a.rating AS rating " +
            "FROM Movie m " +
            "JOIN m.actors a " +
            "WHERE m.id = :movieId")
    List<ActorsProjection> actorsByMovieId(int movieId);

    @Query("SELECT m.title FROM Movie m WHERE m.id = :movieId")
    String titleByMovieId(int movieId);

    @Query("SELECT m.title AS title, m.rating AS rating FROM Movie m WHERE m.rating > :rating")
    List<MovieRatingProjection> moviesWithRatingGreaterThan(BigDecimal rating);
}
