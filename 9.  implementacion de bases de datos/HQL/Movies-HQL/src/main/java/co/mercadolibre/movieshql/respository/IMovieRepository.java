package co.mercadolibre.movieshql.respository;

import co.mercadolibre.movieshql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT m FROM Movie m WHERE m.title LIKE :title%")
    List<Movie> findAllByTitle(@Param("title") String title);
}
