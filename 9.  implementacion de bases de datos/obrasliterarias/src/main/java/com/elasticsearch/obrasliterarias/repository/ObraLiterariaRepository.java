package com.elasticsearch.obrasliterarias.repository;

import com.elasticsearch.obrasliterarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findAllByAutor(String autor);
    List<ObraLiteraria> findAllByNombreContaining(String nombre);
    List<ObraLiteraria> findTop5ByOrderByCantPaginasDesc();
    List<ObraLiteraria> findAllByAnioPublicacionLessThan(Integer anio);
    @Query("{\"match\": {\"editorial.keyword\": \"?0\"}}")
    List<ObraLiteraria> findAllByEditorialCustom(String editorial);
}
