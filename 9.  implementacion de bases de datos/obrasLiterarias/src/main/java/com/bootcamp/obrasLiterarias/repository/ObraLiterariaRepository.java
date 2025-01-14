package com.bootcamp.obrasLiterarias.repository;

import com.bootcamp.obrasLiterarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria,Long> {
}
