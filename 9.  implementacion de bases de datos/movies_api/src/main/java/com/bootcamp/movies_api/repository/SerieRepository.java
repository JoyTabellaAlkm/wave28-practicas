package com.bootcamp.movies_api.repository;

import com.bootcamp.movies_api.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
    @Query("SELECT s FROM Serie s WHERE (SELECT COUNT(se) FROM s.seasons se) > :num")
    List<Serie> findAllBySeasonsSizeGreaterThan(@Param("num") Integer num);
}
