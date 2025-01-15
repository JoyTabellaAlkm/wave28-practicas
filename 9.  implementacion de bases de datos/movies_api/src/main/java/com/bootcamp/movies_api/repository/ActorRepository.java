package com.bootcamp.movies_api.repository;

import com.bootcamp.movies_api.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findAllByFavoriteMovieIsNotNull();
    List<Actor> findByRatingGreaterThan(Double rating);
}
