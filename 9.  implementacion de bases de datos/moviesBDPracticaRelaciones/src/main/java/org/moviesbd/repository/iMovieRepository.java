package org.moviesbd.repository;

import org.moviesbd.entity.movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface iMovieRepository extends JpaRepository<movies, Integer> {

    @Query("select m from actors a inner join actorMovie am on am.actor=a inner join movies m on m=am.movie where a.rating > :valor")
    public List<movies> moviesActorsRaiting(@Param("valor") float valor);

    @Query("select m from movies m join m.genres g where g.name like :genero")
    public List<movies> moviesGenero(@Param("genero") String genero);
}
