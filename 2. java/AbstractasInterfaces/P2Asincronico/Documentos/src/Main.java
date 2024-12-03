//Se plantea desarrollar un programa que permita mediante una interfaz imprimir diferentes
// tipos de documentos.
//
//Entre los tipos de documentos se encuentran:
//
//Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
//Libros en PDF: Incluyen atributos como cantidad de páginas, nombre del autor, título y género.
//Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.
//Representar un escenario donde se creen cada uno de estos objetos y que, por medio de
// un método estático de una interfaz imprimible, se pueda pasar cualquier tipo de documento
//  y sea impreso el contenido.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Camila Lopez", 23, "43567012");
        ArrayList<String> cualidades = new ArrayList<String>();
        Curriculum c1 = new Curriculum(p1, cualidades);

        c1.imprimirContenido();
    }
}

interface IDocumento {
    static void imprimirContenido(IDocumento documento) {
        System.out.println(documento.imprimirContenido());
    }
}

class Persona {
    String nombreCompleto;
    private int edad;
    String dni;

    public Persona (String nombreCompleto, int edad, String dni){
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.dni = dni;
    }
}

class Curriculum implements IDocumento {
    Persona persona;
    private ArrayList<String> habilidades = new ArrayList<String>();

    public Curriculum (Persona persona, ArrayList<String> habilidades){
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimirContenido(){
        return System.out.println(" Persona: " + persona + "Habilidades: " + habilidades);
    }


}




