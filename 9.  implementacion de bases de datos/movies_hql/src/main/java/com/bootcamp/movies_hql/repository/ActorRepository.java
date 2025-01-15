package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.entity.Actor;
import com.bootcamp.movies_hql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Query("select a from Actor as a where a.favouriteMovie is not null")
    List<Actor> findAllWithFavouriteMovie();

    @Query("select a from Actor as a where a.rating > :rating")
    List<Actor> findAllWithRatingGreaterThan(Double rating);

    @Query("select a from Actor as a join a.movies m where m = :movie")
    List<Actor> findAllWhoWorkedIn(Movie movie);
}
