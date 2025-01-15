package com.bootcamp.clotheses.repository;

import com.bootcamp.clotheses.model.Clothe;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Set;

public interface IClotheRepository extends ElasticsearchRepository<Clothe, String> {
    List<Clothe> findAll();

    List<Clothe> findBySize(String size);

    List<Clothe> findByNameContainingIgnoreCase(String name);

    Set<Clothe> findAllByCodeIn(List<String> clothesIds);
}