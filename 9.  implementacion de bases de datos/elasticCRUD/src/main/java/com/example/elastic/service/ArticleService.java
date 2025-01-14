package com.example.elastic.service;

import com.example.elastic.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    public Article save (Article artic);

    public List<Article> findAll();

    public Optional<Article> findById(int id);

    public String deleteArticle (int id);

    public String editArticle (Article article);
}
