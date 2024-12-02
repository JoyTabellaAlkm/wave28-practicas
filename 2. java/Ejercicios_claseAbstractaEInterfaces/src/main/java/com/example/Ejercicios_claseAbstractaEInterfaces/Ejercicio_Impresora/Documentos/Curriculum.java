package com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Impresora.Documentos;

import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Impresora.IImprimible;

import java.util.List;
import java.util.stream.Collectors;

public class Curriculum {

    private String nombre;
    private String apellido;
    private int edad;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" + '\n' +
                "nombre= " + nombre + '\n' +
                "apellido= " + apellido + '\n' +
                "edad= " + edad + '\n' +
                "abilidades= " + habilidades.stream().collect(Collectors.joining(",'\n'")) +
                '}';
    }


}
