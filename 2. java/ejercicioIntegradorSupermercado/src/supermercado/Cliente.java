package supermercado;

public class Cliente {
    private String nombre;
    private String apellido;
    double dni;

    public Cliente(String nombre, String apellido, double dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }
}
