package com.company;

import java.util.List;

public class Curriculum implements IImprimir {

    String nombre;
    List<String> habilidades;

    public Curriculum(String nombre, List<String> habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimible() {
        System.out.println("Data Curriculum: Nombre: " + this.nombre + ", habilidades: " + this.habilidades.toString());
    }
}
