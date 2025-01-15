package com.ar.mercadolibre.obrasliterarias.dto;

public class ObraLiterariaDTO {

    String id;
    String nombre;
    String autor;
    Integer cantidadDePaginas;
    String editorial;
    Integer anioPrimeraPublicacion;

    public ObraLiterariaDTO() {
    }

    public ObraLiterariaDTO(String id, String nombre, String autor, Integer cantidadDePaginas, String editorial, Integer anioPrimeraPublicacion) {
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

    public Integer getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(Integer cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
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
}
