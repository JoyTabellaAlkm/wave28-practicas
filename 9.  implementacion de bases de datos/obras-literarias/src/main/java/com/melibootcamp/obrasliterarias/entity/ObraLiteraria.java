package com.melibootcamp.obrasliterarias.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obrasliterarias") // Nombre del índice en Elasticsearch
public class ObraLiteraria {

    @Id
    private String id; // Identificador único de la obra

    private String nombre; // Nombre de la obra
    private String autor; // Autor de la obra
    private Integer cantidadPaginas; // Cantidad de páginas
    private String editorial; // Nombre de la editorial
    private Integer anioPrimeraPublicacion; // Año de la primera publicación

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(Integer cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getAnioPrimeraPublicacion() {
        return anioPrimeraPublicacion;
    }

    public void setAnioPrimeraPublicacion(Integer anioPrimeraPublicacion) {
        this.anioPrimeraPublicacion = anioPrimeraPublicacion;
    }
// Constructor, getters, setters, toString, etc. son generados automáticamente por Lombok debido a la anotación @Data
}