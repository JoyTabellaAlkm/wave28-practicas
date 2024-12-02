public class LibroPDF implements Imprimible{
    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("LibroPDF{" +
                            "cantidadPaginas=" + cantidadPaginas +
                           ", nombreAutor='" + nombreAutor + '\'' +
                            ", titulo='" + titulo + '\'' +
     ", genero='" + genero + '\'' +
     '}');
        
    }
}
