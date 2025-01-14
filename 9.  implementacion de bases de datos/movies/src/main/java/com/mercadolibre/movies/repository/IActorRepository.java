package com.mercadolibre.movies.repository;

import com.mercadolibre.movies.dto.ActorDTO;
import com.mercadolibre.movies.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Long> {

    @Query("SELECT a.id, a.firstName, a.lastName, a.rating  " +
            "FROM Actor a " +
            "WHERE a.favoriteMovie is not null")
    List<Object[]> getActorsWithFavoriteMovie();

    @Query("SELECT a.id, a.firstName, a.lastName, a.rating  " +
            "FROM Actor a " +
            "WHERE a.rating > ?1")
    List<Object[]> getActorsWithRating(Long rating);

    @Query("SELECT a.id, a.firstName, a.lastName, a.rating  " +
            "FROM Actor a " +
            "JOIN a.movies m " +
            "WHERE m.title LIKE %?1%")
    List<Object[]> getActorsFromMovie(String movie);
}
