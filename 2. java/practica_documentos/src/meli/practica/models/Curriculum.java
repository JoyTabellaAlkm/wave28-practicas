package practica_documentos.src.meli.practica.models;

import java.util.ArrayList;

public class Curriculum implements IImprimible {

    private String nombre;
    private ArrayList<String> habilidades;

    public Curriculum(String nombre, ArrayList<String> habilidades){
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir(){
        System.out.println("-----------------------------");
        System.out.println("Curriculum de: " + this.nombre);
        System.out.println("Habilidades destacadas:");
        for(String habilidad: habilidades){
            System.out.println("-> " + habilidad);
        }
        System.out.println("-----------------------------");
    }
}
