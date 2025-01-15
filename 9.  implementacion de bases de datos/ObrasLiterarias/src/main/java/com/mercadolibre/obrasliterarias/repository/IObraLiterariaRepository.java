package com.mercadolibre.obrasliterarias.repository;

import com.mercadolibre.obrasliterarias.model.ObraLiteraria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    // Retornar las obras de un determinado autor
    @Query("{\"match\": {\"autor\": \"?0\"}}")
    Page<ObraLiteraria> findByAutor(String autor, Pageable pageable);

    // Retornar las obras que contengan palabras claves en sus títulos
    @Query("{\"match\": {\"nombre\": \"?0\"}}")
    Page<ObraLiteraria> findByTitulo(String titulo, Pageable pageable);

    // Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    //@Query("{\"match_all\": {}}, \"size\": 5, \"sort\": [{\"cantidadPaginas\": {\"order\": \"desc\"}}]}")
    Page<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc(Pageable pageable);

    // Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    Page<ObraLiteraria> findByAnioPrimeraPublicacionBefore(int anio, Pageable pageable);

    // Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”
    Page<ObraLiteraria> findByEditorial(String editorial, Pageable pageable);
}
