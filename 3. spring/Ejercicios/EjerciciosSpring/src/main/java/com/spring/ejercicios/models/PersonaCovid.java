package com.spring.ejercicios.models;

import java.util.ArrayList;
import java.util.List;

public class PersonaCovid {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Integer> sintomasCodigos;

    public PersonaCovid(int id, int edad, String apellido, String nombre, List<Integer> sintomasCodigos) {
        this.id = id;
        this.edad = edad;
        this.apellido = apellido;
        this.nombre = nombre;
        this.sintomasCodigos = sintomasCodigos != null ? sintomasCodigos : new ArrayList<>();
    }

    public PersonaCovid(int id, int edad, String apellido, String nombre) {
        this.id = id;
        this.edad = edad;
        this.apellido = apellido;
        this.nombre = nombre;
        this.sintomasCodigos =  new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public List<Integer> getSintomasCodigos() {
        return sintomasCodigos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSintomasCodigos(List<Integer> sintomasCodigos) {
        this.sintomasCodigos = sintomasCodigos;
    }
}
