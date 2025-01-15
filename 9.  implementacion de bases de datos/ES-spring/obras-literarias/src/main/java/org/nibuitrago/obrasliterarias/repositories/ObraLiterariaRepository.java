package org.nibuitrago.obrasliterarias.repositories;

import org.nibuitrago.obrasliterarias.models.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, Long> {
    List<ObraLiteraria> findByAutor(String autor);
}
