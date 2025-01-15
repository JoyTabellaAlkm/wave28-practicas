package com.bootcamp.Movies.repository;

import com.bootcamp.Movies.dto.ActorDto;
import com.bootcamp.Movies.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

    @Query("SELECT a FROM Actor a WHERE a.favouriteMovie IS NOT NULL")
    List<Actor> findActorsWithFavouriteMovie();

    List<ActorDto> findActorsByRatingIsGreaterThan(double rating);
}
