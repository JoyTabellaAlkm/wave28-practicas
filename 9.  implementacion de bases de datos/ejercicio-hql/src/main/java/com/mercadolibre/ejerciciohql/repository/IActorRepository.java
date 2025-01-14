package com.mercadolibre.ejerciciohql.repository;

import com.mercadolibre.ejerciciohql.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Long> {

    @Query("from Actor a where a.favoriteMovie is not null")
    List<Actor> findActorsThatHaveFavoriteMovie();

    @Query("from Actor a where a.rating > :rating")
    List<Actor> findActorsWhereRatingHigherThanGiven(@Param("rating") Double rating);

    @Query("from Actor a join a.movies m where m.id = :id")
    List<Actor> findActorsByMovieId(@Param("id") Long id);

}
