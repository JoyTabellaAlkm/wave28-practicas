import java.util.List;

public class CV implements Imprimible {
    private String nombre;
    private String email;
    private List<String> habilidades;

    // Constructor
    public CV(String nombre, String email, List<String> habilidades) {
        this.nombre = nombre;
        this.email = email;
        this.habilidades = habilidades;
    }

    // Implementación del método obtenerContenido
    @Override
    public String obtenerContenido() {
        return "Curriculum:\nNombre: " + nombre +
               "\nEmail: " + email +
               "\nHabilidades: " + String.join(", ", habilidades);
    }
}
