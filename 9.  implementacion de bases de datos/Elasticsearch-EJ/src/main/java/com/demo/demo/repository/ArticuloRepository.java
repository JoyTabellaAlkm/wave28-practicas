package com.demo.demo.repository;

import com.demo.demo.domain.Articulo;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloRepository extends ElasticsearchRepository<Articulo, String> {
    @Query("{ \"match_all\": {} }")
    List<Articulo> findAll();
}
