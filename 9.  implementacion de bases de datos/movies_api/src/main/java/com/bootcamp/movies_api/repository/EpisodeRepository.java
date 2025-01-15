package com.bootcamp.movies_api.repository;

import com.bootcamp.movies_api.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    @Query("SELECT e FROM Episode e JOIN e.actors a WHERE a.id = :actorId")
    List<Episode> findAllByActor(@Param("actorId") Long actorId);
}
