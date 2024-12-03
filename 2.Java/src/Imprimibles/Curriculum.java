package Imprimibles;

import java.util.ArrayList;

public class Curriculum extends  Docuemento{
    private String nombre;
    private String descripcion;
    private String dni;
    private String edad;
    private ArrayList<String> habilidades;

    public Curriculum(String nombre, String descripcion, String dni, String edad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dni = dni;
        this.edad = edad;

    }


    public void agregarHbilidad(String habilidad){
        this.habilidades.add(habilidad);
    }

    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimiendo Cv: " + documento);
    }

    @Override
    public void imprimirTipoDoc() {
        System.out.println("Tipo de documento: Curriculum");
    }
}

