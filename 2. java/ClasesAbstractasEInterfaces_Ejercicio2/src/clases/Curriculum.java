package clases;

import interfaces.Documento;

import java.util.List;

public class Curriculum implements Documento {

    private String nombre;
    private String apellido;
    private int edad;
    private List<String> atributos;

    public Curriculum(String nombre, String apellido, int edad, List<String> atributos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.atributos = atributos;
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

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public List<String> getAtributos() {
        return this.atributos;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder("Curriculum de" + this.nombre + " " + this.apellido);
        resultado.append("\r\nEdad: ").append(this.edad);
        resultado.append("\r\nAtributos: ");
        for (String at : this.atributos) {
            resultado.append("\r\n");
            resultado.append(at);
        }
        return resultado.toString();
    }
}
