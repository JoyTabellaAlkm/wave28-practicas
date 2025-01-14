package com.obras_literarias.domain;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obra")
public class Obra {
    @Id
    private String id;

    private String name;
    private String autor;

    private int cantidadDePaginas;

    private String editorial;
    private int anoDePublicacion;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAnoDePublicacion(int anoDePublicacion) {
        this.anoDePublicacion = anoDePublicacion;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getName() {
        return name;
    }

    public int getAnoDePublicacion() {
        return anoDePublicacion;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getId() {
        return id;
    }
}
