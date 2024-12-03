public class Libro_pdf implements Imprimible {
    private String titulo;
    private String autor;
    private String genero;
    private int cantidadPaginas;

    // Constructor
    public Libro_pdf(String titulo, String autor, String genero, int cantidadPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.cantidadPaginas = cantidadPaginas;
    }

    // Implementación del método obtenerContenido
    @Override
    public String obtenerContenido() {
        return "Libro PDF:\nTítulo: " + titulo +
               "\nAutor: " + autor +
               "\nGénero: " + genero +
               "\nPáginas: " + cantidadPaginas;
    }
}