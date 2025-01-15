package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.entity.Genre;
import com.bootcamp.movies_hql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select m from Movie m join m.actors a where a.rating > :rating")
    List<Movie> findAllByActorRatingGreaterThan(Double rating);

    @Query("select m from Movie m join m.genre g where g = :genre")
    List<Movie> findAllByGenre(Genre genre);
}
