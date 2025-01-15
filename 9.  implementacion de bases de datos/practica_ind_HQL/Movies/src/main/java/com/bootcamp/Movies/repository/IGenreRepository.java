package com.bootcamp.Movies.repository;

import com.bootcamp.Movies.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGenreRepository extends JpaRepository<Genre,Integer> {
    @Query("SELECT m.title AS title FROM Genre g JOIN g.movies m WHERE g.id = :genreId")
    List<String> genreMovies(Integer genreId);

    @Query("SELECT g.name FROM Genre g WHERE g.id = :genreId")
    String nameByGenreId(Integer genreId);
}
