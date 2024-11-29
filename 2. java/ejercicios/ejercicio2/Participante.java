package ejercicios.ejercicio2;

public class Participante {
    private String nombre;
    private String apellido;
    private int edad;
    private int id;
    private int dni;
    private int telefono;
    private int nroEmergencia;
    private String grupoSanguineo;

    public Participante(String nombre, String apellido, int edad, int id, int dni, int telefono, int nroEmergencia, String grupoSanguineo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.id = id;
        this.dni = dni;
        this.telefono = telefono;
        this.nroEmergencia = nroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
