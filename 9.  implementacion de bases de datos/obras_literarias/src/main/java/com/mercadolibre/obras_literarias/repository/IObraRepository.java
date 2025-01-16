package com.mercadolibre.obras_literarias.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.mercadolibre.obras_literarias.entity.Obra;

public interface IObraRepository extends ElasticsearchRepository<Obra, String> {

    public Iterable<Obra> findAllByAutor(String autor);
    public Iterable<Obra> findAllByNombreLike(String nombre);

    @Query("{\"bool\": {\"must\": []}}")
    public Page<Obra> findTop5MostCantidadPaginas(Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"range\": {\"anio_publicacion\": {\"lte\": \"?0\"}}}]}}")
    public Iterable<Obra> findAllByAnioPublicacionDown(int anioPublicacion);

    public Iterable<Obra> findAllByEditorial(String editorial);

}
