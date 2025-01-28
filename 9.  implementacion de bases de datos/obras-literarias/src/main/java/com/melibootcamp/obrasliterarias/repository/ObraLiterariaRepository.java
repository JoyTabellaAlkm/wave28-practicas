package com.melibootcamp.obrasliterarias.repository;

import com.melibootcamp.obrasliterarias.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    List<ObraLiteraria> findByAutor(String autor);
    List<ObraLiteraria> findByNombreContaining(String pattern);
    List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();
    List<ObraLiteraria> findByAnioPrimeraPublicacionIsLessThan(Integer year);
    List<ObraLiteraria> findByEditorialEquals(String editorial);

}
