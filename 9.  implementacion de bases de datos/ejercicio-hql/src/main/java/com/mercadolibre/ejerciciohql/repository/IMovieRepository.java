package com.mercadolibre.ejerciciohql.repository;

import com.mercadolibre.ejerciciohql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

    @Query("from Movie m join m.actors a where a.rating > :rating")
    List<Movie> findMoviesWhereActorRatingHigherThanParam(@Param("rating") Double rating);

    //Listar todas las películas que pertenezcan al <género recibido por parámetro>

}
