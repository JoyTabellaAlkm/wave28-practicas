package clases;

import interfaces.Imprimible;

public class Curriculum implements Imprimible {
    String nombre;
    String habilidades;

    public Curriculum(String nombre, String habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", habilidades='" + habilidades + '\'' +
                '}';
    }

    @Override
    public void imprimirContenido() {
        System.out.println(this);
    }
}
