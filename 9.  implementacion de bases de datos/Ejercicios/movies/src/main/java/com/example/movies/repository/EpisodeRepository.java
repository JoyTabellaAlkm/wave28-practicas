package com.example.movies.repository;

import com.example.movies.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Integer> {
    @Query("SELECT ae.episode FROM ActorEpisode ae WHERE ae.actor.firstName LIKE :firstName% AND ae.actor.lastName LIKE :lastName%")
    List<Episode> findEpisodesByActor(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
