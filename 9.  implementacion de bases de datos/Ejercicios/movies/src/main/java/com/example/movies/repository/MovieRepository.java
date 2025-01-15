package com.example.movies.repository;

import com.example.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query("SELECT am.movie FROM ActorMovie am WHERE am.actor.rating > :rating")
    List<Movie> findMoviesByActorRatingGreaterThan(@Param("rating") double rating);

    @Query("SELECT m FROM Movie m WHERE m.genre.id IN (SELECT g.id FROM Genre g WHERE g.name = :genre)")
    List<Movie> findMoviesByGenre(@Param("genre") String genre);

}
