package com.example.movies_api.repository;

import com.example.movies_api.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorsRepository extends JpaRepository<Actor, Integer> {
    List<Actor> findByMovieIsNotNull();

    List<Actor> findByRatingGreaterThan(Double ratingIsGreaterThan);
}
