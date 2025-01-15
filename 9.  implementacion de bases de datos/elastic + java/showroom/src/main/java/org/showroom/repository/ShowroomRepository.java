package org.showroom.repository;

import org.showroom.entity.Ropa;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ShowroomRepository extends ElasticsearchRepository<Ropa, String> {

    public Ropa findByCodigoEquals(int Codigo);

    List<Ropa> findByTalle(String talle);

    List<Ropa> findByNombreIgnoreCase(String nombre);

    @Query("{\"match_all\": {}}")
    List<Ropa> findAllRopa();
}
