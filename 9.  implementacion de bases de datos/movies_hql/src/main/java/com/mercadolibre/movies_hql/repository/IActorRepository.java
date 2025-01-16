package com.mercadolibre.movies_hql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mercadolibre.movies_hql.entity.Actor;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

    @Query("SELECT a FROM Actor a WHERE a.favorite IS NOT NULL")
    public List<Actor> findAllHasFavoriteMovie();

    @Query("SELECT a FROM Actor a WHERE a.rating >= ?1")
    public List<Actor> findAllByRatingUp(float rating);

    @Query("SELECT am.actor FROM ActorMovie am WHERE am.movie.id = ?1")
    public List<Actor> findAllByWorkInMovie(int movieId);

}
