package org.nibuitrago.obrasliterarias.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="obrasliterarias")
public class ObraLiteraria {
    @Id
    private Long id;
    private String nombre;
    private String autor;
    private int cantidadPaginas;
    private String editorial;
    private int anoPrimeraPublicacion;

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

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnoPrimeraPublicacion() {
        return anoPrimeraPublicacion;
    }

    public void setAnoPrimeraPublicacion(int anoPrimeraPublicacion) {
        this.anoPrimeraPublicacion = anoPrimeraPublicacion;
    }
}
