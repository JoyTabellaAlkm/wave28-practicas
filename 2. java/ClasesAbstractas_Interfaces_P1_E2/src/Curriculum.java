public class Curriculum implements Imprimible{
    private String nombre;
    private String apellido;
    private Integer edad;

    public Curriculum(String nombre, String apellido, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
