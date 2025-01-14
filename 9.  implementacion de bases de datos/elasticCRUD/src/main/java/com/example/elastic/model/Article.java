package com.example.elastic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Document(indexName = "blog")
public class Article {
    @Id
    private String id;
    private String title;
    private Integer pages;
    private String editorial;
    private Integer anioPublicacion;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authorsList;


    public Article(String id, String title, Integer pages, String editorial, Integer anioPublicacion, List<Author> authorsList) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.authorsList = authorsList;
    }

    public Article() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public List<Author> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<Author> authorsList) {
        this.authorsList = authorsList;
    }
}
