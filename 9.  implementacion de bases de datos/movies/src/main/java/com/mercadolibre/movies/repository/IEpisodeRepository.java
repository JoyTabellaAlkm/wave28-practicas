package com.mercadolibre.movies.repository;


import com.mercadolibre.movies.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode,Integer> {
    @Query("SELECT ep FROM Episode ep JOIN ep.actorEpisodes aep " +
            "JOIN aep.actor a WHERE a.firstName=:nombre AND a.lastName=:apellido")
    List<Episode> findEpisodesByActorEpisodes(@Param("nombre")String nombre,
                                              @Param("apellido")String apellido);
}
