package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_2;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private Integer edad;

    public Persona(String apellido, String dni, Integer edad, String nombre) {
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                '}';
    }
}
