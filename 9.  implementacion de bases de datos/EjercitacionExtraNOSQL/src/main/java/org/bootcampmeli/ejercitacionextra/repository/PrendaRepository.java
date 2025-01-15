package org.bootcampmeli.ejercitacionextra.repository;

import org.bootcampmeli.ejercitacionextra.model.Prenda;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PrendaRepository extends ElasticsearchRepository<Prenda, String> {

    Prenda findByCodigo(String codigo);
    List<Prenda> findAllByTalle(String talle);
    @Query("{\"match\": {\"nombre\": \"?0\"}}")
    List<Prenda> findAllByNombreCustom(String nombre);


}
