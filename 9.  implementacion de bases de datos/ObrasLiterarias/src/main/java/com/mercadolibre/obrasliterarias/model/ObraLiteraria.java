package com.mercadolibre.obrasliterarias.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obras-literarias")
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private int cantidadPaginas;
    private String editorial;
    private int anioPrimeraPublicacion;

    public ObraLiteraria() {
    }

    public ObraLiteraria(String nombre, String autor, int cantidadPaginas, String editorial, int anioPrimeraPublicacion) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
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

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnioPrimeraPublicacion() {
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

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAnioPrimeraPublicacion(int anioPrimeraPublicacion) {
        this.anioPrimeraPublicacion = anioPrimeraPublicacion;
    }
}
