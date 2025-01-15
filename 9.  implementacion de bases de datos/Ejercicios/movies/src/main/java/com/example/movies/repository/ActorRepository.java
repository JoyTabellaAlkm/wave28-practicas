package com.example.movies.repository;

import com.example.movies.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findActorByFavoriteMovie();
    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> findActorByRatingGreaterThan(@Param("rating") double rating);
}
