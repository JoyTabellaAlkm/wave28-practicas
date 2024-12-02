package org.example;

import java.util.List;

public class Curriculums extends Documento{
    private String nombre;
    private String edad;
    private String telefono;
    private List<String> habilidades ;


    public Curriculums(String nombre, String edad, String telefono, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.habilidades = habilidades;
    }


    @Override
    public String toString() {
        return "Curriculums{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", habilidades=" + habilidades +
                "} " ;
    }
}
