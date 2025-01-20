package co.mercadolibre.movieshql.respository;

import co.mercadolibre.movieshql.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {
    List<Actor> findAllByFavoriteMovieIsNotNull();
    List<Actor> findAllByRatingGreaterThan(Double param);
}
