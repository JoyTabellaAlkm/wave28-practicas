package com.mercadolibre.obraliteraria.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;



@Document(indexName = "libros")
public class ObraLiteraria {
    @Id
    private Long id;
    private String nombre;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private int primeraPublicacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getPrimeraPublicacion() {
        return primeraPublicacion;
    }

    public void setPrimeraPublicacion(int primeraPublicacion) {
        this.primeraPublicacion = primeraPublicacion;
    }
}
