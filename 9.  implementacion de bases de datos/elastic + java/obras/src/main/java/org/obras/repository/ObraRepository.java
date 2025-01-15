package org.obras.repository;

import org.obras.model.Obra;
import org.springframework.data.domain.Limit;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ObraRepository extends ElasticsearchRepository<Obra, String> {

    List<Obra> findByAnio(String anio);

    @Query("{\"match_phrase\": {\"autor\": \"?0\"}}")
    List<Obra> findByAutor(@Param("autor") String autor);

    List<Obra> findTop5ByOrderByPaginasDesc();
}
