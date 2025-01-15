package com.bootcamp.ejercicio_obras.repository;

import com.bootcamp.ejercicio_obras.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findByAutor(String autor);
    List<ObraLiteraria> findByNombreContaining(String palabraClave);
    List<ObraLiteraria> findByAnioPrimeraPublicacionLessThan(int anio);
    List<ObraLiteraria> findByEditorial(String editorial);
}
