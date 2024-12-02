package ejercicio2.clases;

public class Curriculum extends Documento{
    private int edad;
    private String nombre;
    private String apellido;
    private String puesto;

    public Curriculum(int edad, String nombre, String apellido, String puesto) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", puesto='" + puesto + '\'' +
                '}';
    }
}
