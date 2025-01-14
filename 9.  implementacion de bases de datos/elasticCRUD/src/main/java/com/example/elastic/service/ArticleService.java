package com.example.elastic.service;

import com.example.elastic.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    public Article save (Article artic);

    public List<Article> findAll();

    public Optional<Article> findById(String id);

    public String deleteArticle (String id);

    public String editArticle (Article article);

    List<Article> findByAuthorName(String name);
}
