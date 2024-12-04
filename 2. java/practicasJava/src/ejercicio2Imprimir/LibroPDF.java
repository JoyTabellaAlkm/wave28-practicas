package ejercicio2Imprimir;

public class LibroPDF implements IImprimir {
    private String titulo;
    private String nombreAutor;
    private int cantidadPaginas;
    private String genero;

    public LibroPDF(String titulo, String nombreAutor, int cantidadPaginas, String genero) {
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.cantidadPaginas = cantidadPaginas;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "titulo='" + titulo + '\'' +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public void imprimir(){
        System.out.println(toString());
    }
}
