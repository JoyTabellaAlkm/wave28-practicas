package clasesAbstractas.ejGrupal1.ej2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Documento{
    private String nombre;
    private String apellido;
    private int edad;
    private String descripcion;
    private List<String> habilidades = new ArrayList<>();

    public Curriculum(String nombre, String apellido, int edad, String descripcion, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.descripcion = descripcion;
        this.habilidades = habilidades;
    }
    public Curriculum(String nombre, String apellido, int edad, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.descripcion = descripcion;
    }

    @Override
    public void imprimir() {
        System.out.println("----- Imprimiendo Curriculum -----");
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Apellido: " + this.getApellido());
        System.out.println("Edad: " + this.getEdad());
        System.out.println("Descripcion: " + this.getDescripcion());
        this.getHabilidades().forEach(hab -> System.out.println("Habilidad: " + hab));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
