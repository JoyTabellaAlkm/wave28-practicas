
public class Libro {

    String titulo;
    String autor;
    int ejemplares;

    public Libro(String titulo, String autor, int ejemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
    }

    public int cantidadEjemplares() {
        return ejemplares;
    }

    public String mostrarlibro() {
        return titulo + " - " + autor + " - " + ejemplares;
    }
}
