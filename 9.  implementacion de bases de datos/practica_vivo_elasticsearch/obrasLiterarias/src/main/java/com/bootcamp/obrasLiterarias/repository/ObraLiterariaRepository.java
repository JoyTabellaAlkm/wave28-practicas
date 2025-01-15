package com.bootcamp.obrasLiterarias.repository;

import com.bootcamp.obrasLiterarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria,Long> {
    List<ObraLiteraria> findAllByAutor(String autor);
    List<ObraLiteraria> findAllByNombre(String nombre);
    List<ObraLiteraria> findTop5ByOrderByCantidadDePaginasDesc();
    List<ObraLiteraria> getObraLiterariaByAnioDePublicacionLessThan(Integer anio);
    @Query("{ \"term\": {\"editorial.keyword\": \"?0\"}}")
    List<ObraLiteraria> findallByEditorial(String editorial);
}
