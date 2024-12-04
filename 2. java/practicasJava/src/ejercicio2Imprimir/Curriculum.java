package ejercicio2Imprimir;

import java.util.List;

public class Curriculum implements IImprimir{
    private String nombre;
    private String apellido;
    private int edad;
    private String educacion;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, int edad, String educacion, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.educacion = educacion;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", educacion='" + educacion + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public void imprimir(){
        System.out.println(toString());
    }
}
