public class LibroPdf implements IImprimible{
    private String titulo;
    private String autor;
    private String genero;
    private int paginas;

    public LibroPdf(String titulo, String autor, String genero, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.paginas = paginas;
    }

    @Override
    public String obtenerContenido() {
        return "Libro PDF: " + titulo + "\nAutor: " + autor + "\nGenereo: " + genero + "\nNumero de paginas: " + paginas;
    }
}
