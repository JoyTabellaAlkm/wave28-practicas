package com.example.elastic.controller;

import com.example.elastic.model.Article;
import com.example.elastic.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/article/new")
    public Article save (@RequestBody Article artic) {
        return articleService.save(artic);

    }

    @GetMapping("/article")
    public List<Article> findAll () {

        return articleService.findAll();
    }

    @GetMapping ("/article/{id}")
    //va optional porque puede que devuelva como puede que no
    public Optional<Article> findById(@PathVariable String id) {

        return articleService.findById(id);
    }

    @DeleteMapping ("article/delete/{id}")
    public String deleteArticle (@PathVariable String id) {

        return articleService.deleteArticle(id);
    }

    @PutMapping ("article/edit")
    public String editArticle (@RequestBody Article artic) {

        return articleService.editArticle(artic);
    }

    @GetMapping ("/article")
    //va optional porque puede que devuelva como puede que no
    public List<Article> findByAuthorName(@RequestParam String name) {
        return articleService.findByAuthorName(name);
    }

}
