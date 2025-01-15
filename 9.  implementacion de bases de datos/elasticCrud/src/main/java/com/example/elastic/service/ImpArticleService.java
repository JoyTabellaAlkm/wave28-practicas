package com.example.elastic.service;

import com.example.elastic.model.Article;
import com.example.elastic.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpArticleService implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article save (Article artic) {

        return articleRepository.save(artic);
    }

    @Override
    public List<Article> findAll() {
        return (List<Article>) articleRepository.findAll();
    }

    @Override
    //va optional porque puede que devuelva como puede que no
    public Optional<Article> findById (int id) {
        return articleRepository.findById(id);

    }

    @Override
    public String deleteArticle(int id) {
        articleRepository.deleteById(id);
        return "Artículo eliminado correctamente";
    }

    @Override
    public String editArticle (Article art) {
        articleRepository.save(art);
        return "Articulo modificado correctamente";
    }
}
