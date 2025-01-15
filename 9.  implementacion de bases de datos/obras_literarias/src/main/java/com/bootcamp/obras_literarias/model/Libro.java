package com.bootcamp.obras_literarias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "libreria")
public class Libro {
    @Id
    private Integer id;
    @Field(type = FieldType.Text, name = "title")
    private String title;
    @Field(type = FieldType.Object, includeInParent = true)
    private Autor autor;
    @Field(type = FieldType.Integer, name = "amount_pages")
    private Integer amountPages;
    @Field(type = FieldType.Text, name = "editorial")
    private String editorial;
    @Field(type = FieldType.Integer, name = "release_year")
    private Integer releaseYear;

    public Integer getAmountPages() {
        return amountPages;
    }

    public void setAmountPages(Integer amountPages) {
        this.amountPages = amountPages;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(id, libro.id) && Objects.equals(title, libro.title) && Objects.equals(autor, libro.autor) && Objects.equals(amountPages, libro.amountPages) && Objects.equals(editorial, libro.editorial) && Objects.equals(releaseYear, libro.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, autor, amountPages, editorial, releaseYear);
    }
}
