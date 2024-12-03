package ejercicio2.clases;

import ejercicio2.interfaces.IDocumento;

import java.util.List;

public class Curriculum implements IDocumento {

    private String nombre;
    private String dni;
    private String correo;
    List<String> habilidades;

    @Override
    public void imprimir() {
        System.out.println("Curriculum -> Nombre: " + this.nombre);
        System.out.println("DNI: " + this.dni);
        System.out.println("Correo: " + this.correo);
        System.out.println("Habilidades: " + this.habilidades);
    }

    public Curriculum(String nombre, String dni, String correo, List<String> habilidades) {
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.habilidades = habilidades;
    }
}
