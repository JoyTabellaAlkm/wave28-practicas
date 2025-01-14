package com.example.elastic.repository;

import com.example.elastic.model.Article;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {

    @Query ("{\n" +
            "  \"query\": {\n" +
            "    \"match_all\": {}\n" +
            "  }")
    public List<Article> findAll();

}
