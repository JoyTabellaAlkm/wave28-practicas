package com.mercadolibre.movies_hql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mercadolibre.movies_hql.entity.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT m FROM Movie m INNER JOIN ActorMovie am ON m = am.movie GROUP BY m HAVING AVG(am.actor.rating) >= ?1")
    public List<Movie> findAllByActorRatingUp(double rating);

    @Query("SELECT m FROM Movie m WHERE m.genre.id = ?1")
    public List<Movie> findAllByGenre(int genreId);

}
