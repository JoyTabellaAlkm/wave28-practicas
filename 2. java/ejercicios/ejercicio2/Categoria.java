package ejercicios.ejercicio2;

public abstract class Categoria {
    private int id;
    private String nombre;
    private String descripcion;

    public Categoria(String descripcion, String nombre, int id) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                '}';
    }
}
