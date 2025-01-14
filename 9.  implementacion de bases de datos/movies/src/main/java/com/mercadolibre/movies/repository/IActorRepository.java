package com.mercadolibre.movies.repository;

import com.mercadolibre.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor,Integer> {
    @Query("SELECT a FROM Actor a WHERE a.favoriteMovieId IS NOT NULL")
    List<Actor> findActorsByFavoriteMovieIdExists();

    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> findActorsByRatingAfterParam(@Param("rating")BigDecimal rating);

    @Query("SELECT a FROM Actor a JOIN a.actorMovies am JOIN am.movie mov WHERE mov.title = :movieTitle")
    List<Actor> findActorsByNameMovie(@Param("movieTitle")String movieTitle);
}
