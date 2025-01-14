package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.entity.Actor;
import com.bootcamp.movies_hql.entity.Episode;
import com.bootcamp.movies_hql.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    @Query("select s from Serie s where s.seasons.size > :seasonCount")
    List<Serie> findAllBySeasonCountGreaterThan(Integer seasonCount);

    @Query("select distinct e from Episode e join e.actors a where a = :actor")
    List<Episode> findEpisodesByActor(Actor actor);
}
