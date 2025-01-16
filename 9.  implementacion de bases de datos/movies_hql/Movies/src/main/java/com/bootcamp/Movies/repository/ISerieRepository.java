package com.bootcamp.Movies.repository;

import com.bootcamp.Movies.entity.Season;
import com.bootcamp.Movies.repository.projection.SerieSeasonsCountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISerieRepository extends JpaRepository<Season,Integer> {

    @Query("SELECT s.title AS serie, s.seasons.size AS seeasonsNumber FROM Serie s JOIN s.seasons ss WHERE s.seasons.size > :seasonsNumber")
    List<SerieSeasonsCountProjection> seriesWithSeasonsNumberGreaterThan(Integer seasonsNumber);
}
