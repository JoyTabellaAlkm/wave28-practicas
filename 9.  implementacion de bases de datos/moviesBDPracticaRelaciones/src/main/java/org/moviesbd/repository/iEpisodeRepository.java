package org.moviesbd.repository;

import org.moviesbd.entity.episodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface iEpisodeRepository extends JpaRepository<episodes, Integer> {

    @Query("select e from episodes e join e.actorEpisodes ae join ae.actor a where a.firstName like :actor")
    public List<episodes> episodesActor(@Param("actor") String actor);
}
