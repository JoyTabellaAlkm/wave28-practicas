package org.bootcampmeli.hqlmovies.repository;

import org.bootcampmeli.hqlmovies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


    @Query("SELECT m FROM Movie m")
    List<Movie> findAllMovies();

    @Query("SELECT m FROM Movie m where m.genre.name = :genre")
    List<Movie> getMovieByGenre(String genre);
}
