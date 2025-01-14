package com.mercadolibre.ejerciciohql.repository;

import com.mercadolibre.ejerciciohql.entity.Genre;
import com.mercadolibre.ejerciciohql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

    @Query("FROM Movie m WHERE EXISTS (SELECT 1 FROM Actor a JOIN a.movies am WHERE am.id = m.id GROUP BY am.id HAVING MIN(a.rating) > :rating)")
    List<Movie> findMoviesWhereActorRatingHigherThanParam(@Param("rating") Double rating);

    @Query("FROM Movie m WHERE m.genre.name = :genreName")
    List<Movie> findMoviesByGenreName(@Param("genreName") String genreName);

}
