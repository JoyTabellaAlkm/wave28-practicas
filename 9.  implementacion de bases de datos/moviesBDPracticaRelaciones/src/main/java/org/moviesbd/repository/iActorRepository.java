package org.moviesbd.repository;

import org.moviesbd.entity.actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface iActorRepository extends JpaRepository<actors, Integer> {

    public List<actors> findAllByMovieNotNull();

    public List<actors> findAllByRatingGreaterThan(float ratingIsGreaterThan);

    @Query("select a from actors a inner join actorMovie am on a=am.actor inner join movies m on am.movie=m where m.title like :nombre")
    public List<actors> workIn(@Param("nombre") String nombre);
}
