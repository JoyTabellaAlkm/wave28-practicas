package practicaClasesAbstractasInterfaces.interfazImprimible.entidades;

public class Libro extends Documento {
    private String genero;
    private int cantidadPaginas;
    private String autor;
    private String titulo;

    public Libro(String genero, int cantidadPaginas, String autor, String titulo) {
        this.genero = genero;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
    }

    public Libro() {
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String gettitulo() {
        return titulo;
    }

    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "genero='" + genero + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
