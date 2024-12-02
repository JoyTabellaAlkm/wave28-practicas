import java.util.ArrayList;

public class Curriculum extends Documento {

    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private ArrayList<String> habilidades;

    public Curriculum(String documento, String nombre, String apellido, String dni, int edad) {
        super(documento);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    public void agregarHabilidad(String habilidad) {
        this.habilidades.add(habilidad);

    }

    @Override
    public void imprimirDocumento(String documento) {
        System.out.println("Imprimiendo documento " + documento);
    }
}
