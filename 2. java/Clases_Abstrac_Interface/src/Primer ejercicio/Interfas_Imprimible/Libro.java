public class Libro implements Imprimible{
    private String titulo;
    private int cantidadDePaginas;
    private String nombreAutor;
    private String genero;

    public Libro(String titulo, int cantidadDePaginas, String nombreAutor, String genero) {
        this.titulo = titulo;
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreAutor = nombreAutor;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libros [titulo=" + titulo + ", cantidadDePaginas=" + cantidadDePaginas + ", nombreAutor=" + nombreAutor
                + ", genero=" + genero + "]";
    }

    
    
    
}