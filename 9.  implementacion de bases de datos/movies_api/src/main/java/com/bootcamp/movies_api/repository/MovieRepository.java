package com.bootcamp.movies_api.repository;

import com.bootcamp.movies_api.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select m from Movie m join m.genre g where g.name = :genre")
    List<Movie> findAllByGenre(@Param("genre") String genre);

    @Query("SELECT m FROM Movie m WHERE m.title LIKE :title%")
    List<Movie> findAllByTitle(@Param("title") String title);
}
