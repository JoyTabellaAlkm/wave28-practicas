package com.obras_literarias.repository;

import com.obras_literarias.domain.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IObraRepository extends ElasticsearchRepository<Obra, String> {
}
