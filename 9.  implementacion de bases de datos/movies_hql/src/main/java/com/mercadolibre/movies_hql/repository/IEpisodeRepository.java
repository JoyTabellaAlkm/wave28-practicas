package com.mercadolibre.movies_hql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mercadolibre.movies_hql.entity.Episode;

public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {

    @Query("SELECT ae.episode FROM ActorEpisode ae WHERE ae.actor.id = ?1")
    public List<Episode> findAllEpisodesByActor(int actorId);

}
