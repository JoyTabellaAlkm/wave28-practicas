package com.ar.mercadolibre.obrasliterarias.repository;

import com.ar.mercadolibre.obrasliterarias.entity.ObraLiteraria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"autor\": {\"query\": \"?0\", \"operator\": \"and\"}}}]}}")
    Page<ObraLiteraria> findByAutorContainingIgnoreCase(String autor, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"nombre\": {\"query\": \"?0\", \"operator\": \"and\"}}}]}}")
    Page<ObraLiteraria> findBynombreContainingIgnoreCase(String nombre, Pageable pageable);

    List<ObraLiteraria> findTop5ByOrderByCantidadDePaginasDesc();

    Page<ObraLiteraria> findByAnioPrimeraPublicacionBefore(Integer anio, Pageable pageable);

    Page<ObraLiteraria> findByEditorial(String editorial, Pageable pageable);
}
