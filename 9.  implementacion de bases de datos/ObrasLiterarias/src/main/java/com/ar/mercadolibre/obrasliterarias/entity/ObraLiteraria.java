package com.ar.mercadolibre.obrasliterarias.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obras-literarias")
public class ObraLiteraria {

    @Id
    String id;
    String nombre;
    String autor;
    Integer cantidadDePaginas;
    String editorial;
    Integer anioPrimeraPublicacion;

    public ObraLiteraria() {}

    public ObraLiteraria(String id, String nombre, String autor, Integer cantidadDePaginas, String editorial, Integer anioPrimeraPublicacion) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.cantidadDePaginas = cantidadDePaginas;
        this.editorial = editorial;
        this.anioPrimeraPublicacion = anioPrimeraPublicacion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public Integer getAnioPrimeraPublicacion() {
        return anioPrimeraPublicacion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCantidadDePaginas(Integer cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAnioPrimeraPublicacion(Integer anioPrimeraPublicacion) {
        this.anioPrimeraPublicacion = anioPrimeraPublicacion;
    }
}
