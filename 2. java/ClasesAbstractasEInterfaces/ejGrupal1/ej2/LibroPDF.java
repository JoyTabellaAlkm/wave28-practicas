package clasesAbstractas.ejGrupal1.ej2;

public class LibroPDF extends Documento{

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
        System.out.println("----- Imprimiendo Libro PDF -----");
        System.out.println("Titulo: " + this.getTitulo());
        System.out.println("Autor: " + this.getNombreAutor());
        System.out.println("Genero: " + this.getGenero());
        System.out.println("Cantidad de paginas: " + this.getCantidadPaginas());
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
